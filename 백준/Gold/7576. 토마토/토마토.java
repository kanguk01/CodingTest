import java.io.*;
import java.util.*;


public class Main {
    /**
     * 토마토
     * -1 = 토마토가 없는 칸
     *  0 = 안 익은 토마토
     *  1 = 익은 토마토
     * 익은 토마토의 상하좌우만 익으며, 전체 토마토가 익기까지의 시일을 구하는 문제
     * 모든 토마토가 익을 수 없는 경우에는 -1 출력
     * <흐름>
     *     1. 일단 익은 토마토의 위치를 파악한다.
     *     2. 익은 토마토 상하좌우 검사 후 0인 부분을 1로 바꾼다.
     *     3. 그러면 익은 토마토가 또 갱신된다.
     *     4. 이걸 반복하다가, 익은 토마토 주변에 -1밖에 없거나 / 0인 토마토가 없을 경우 멈춘다
     *     5. 전자면 -1 출력, 후자면 일수 출력
     * </흐름>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] tomatoFarm = new int[N][M];
        ArrayList<int[]> matureTomato = new ArrayList<>();
        for (int i = 0; i < N; i++) { // 농장 채움
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoFarm[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoFarm[i][j] == 1) { // 익은 토마토는 미리 저장
                    matureTomato.add(new int[]{i,j});
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐인데 익은 토마토의 좌푯값을 넣기 위해
        for (int i = 0; i < matureTomato.size(); i++) {
            queue.offer(matureTomato.get(i));
        }

        int[] dr = {-1, 1, 0, 0}; // 상하좌우 이동
        int[] dc = {0, 0, -1, 1};
        int days = -1;

        while (!queue.isEmpty()) { // BFS
            int size = queue.size();
            days++;

            for (int i = 0; i < size; i++) { // 현재 익은 토마토 좌표
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for (int j = 0; j < 4; j++) { // 상하좌우 검사
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && tomatoFarm[nr][nc] == 0) { // 상하좌우 중에 0이면
                        tomatoFarm[nr][nc] = 1; // 익고
                        queue.offer(new int[]{nr, nc}); // 큐에 추가
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) { // 다 끝났는데 0 있으면 다 못익힌거 -> -1출력
            for (int j = 0; j < M; j++) {
                if (tomatoFarm[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(days);

    }
}
