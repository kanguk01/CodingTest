import java.io.*;
import java.util.*;


public class Main {
    /*
    쉬운 최단거리

    <입력>
    첫 줄 : 세로 n, 가로 m
    두번째 줄 이후 : 땅
        1 : 갈 수 있는 땅
        2 : 목표지점
        0 : 갈 수 없느 땅

    <출럭>
    각 지점에서 목표지점까리의 거리 출력
    0은 0 출력, 갈 수 없는 곳은 -1 출력

    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startN = 0;
        int startM = 0;

        int[][] ground = new int[n][m];
        int[][] answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 2) {
                    startN = i;
                    startM = j;
                    answer[i][j] = 0;
                } else if (value == 0) {
                    answer[i][j] = 0;
                } else {
                    ground[i][j] = value;
                    answer[i][j] = -1;
                }
            }
        }

        Queue<int[]> bfs = new LinkedList<>();

        answer[startN][startM] = 0;
        bfs.offer(new int[]{startN,startM});

        int[] dx = {0, 0, -1, 1}; // 상하좌우
        int[] dy = {-1, 1, 0, 0}; // 상하좌우

        while (!bfs.isEmpty()) {
            int[] current = bfs.poll();
            int curX = current[0];
            int curY = current[1];

            for (int i = 0; i < 4; i++) {
                int aX = curX + dx[i];
                int aY = curY + dy[i];

                if ((aX < 0 || aY < 0 || aX >= n || aY >= m)) {
                    continue;
                }
                if (ground[aX][aY] != 0 && answer[aX][aY] == -1) {
                    answer[aX][aY] = answer[curX][curY] + 1;
                    bfs.offer(new int[]{aX, aY});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(answer[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
    }
}
