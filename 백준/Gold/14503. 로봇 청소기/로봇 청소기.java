import java.io.*;
import java.util.*;


public class Main {
    /**
     * 청소
     * 첫 줄은 방의 크기 N * M 입력받음 (가로N, 세로M칸)
     * 그 다음줄은 로봇 청소기의 현재 위치를 입력받음 (r,c) -> (위에서 r+1줄, 왼쪽에서  c+1번째) / 그리고 현재 방향 입력받음 (0 북, 1 동, 2 남, 3 서)
     * 그 다음줄부터 현재 방의 상태 입력 (0은 청소해야하는방, 1은 벽)
     *----------------
     * 청소 루틴
     * 1. 현재 방을 청소한다.
     * 2. 주변 4방향에 청소가 안된 0이 없는경우 -> 그상태로 한 칸 후진한다. (후진할 수 없다면 멈춤)
     * 3. 청소가 안된 0이 있는경우 -> 반시계방향으로 90도 회전 후 앞에있는 방이 청소를 해야하면 한다.
     * ---------------
     * 청소가 끝나는 조건 -> 주변 4방향에 0이 없고, 현재 방향 기준 뒤쪽이 1인경우 (r + dr[d], c + dc[d]로 방향 설정)
     * 0 = 청소 해야하는 곳 / 1 = 벽 / 2 = 청소 한 곳 (벽x 청소대상x)
     */

    private static int N, M, r, c, d;
    private static int[][] room;
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        // 두번째줄 입력받음
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = clean();
        System.out.println(answer);
    }

    private static int clean() {
        int count = 0;
        while (true) {
            if(room[r][c]==0) {
                room[r][c] = 2; //일단 청소 한번 하고
                count++;
            }
            // 4방향 모두 청소를 할 수 없다면
            if (room[r + dr[0]][c + dc[0]] != 0 && room[r + dr[1]][c + dc[1]] != 0 && room[r + dr[2]][c + dc[2]] != 0 && room[r + dr[3]][c + dc[3]] != 0) {
                if (room[r - dr[d]][c - dc[d]] == 1) { // 뒤가 벽이면 멈춤
                    break;
                } else { // 뒤가 벽이 아니면 한칸 후진
                    r -= dr[d];
                    c -= dc[d];
                }
            } else { // 그게 아니면 반시계로 회전 (d-1)
                rotate();// 일단 먼저 회전하고
                r += dr[d];
                c += dc[d]; // 전진
            }
        }
        return count;
    }
    private static void rotate() { // 로봇청소기 반시계로 90도 회전
        if (d == 0) d = 4;
        d -= 1; //
        if (room[r + dr[d]][c + dc[d]] != 0){ // 앞이 청소할 수 있는 블럭일 때까지 회전한다.
            rotate();
        }
    }
}
