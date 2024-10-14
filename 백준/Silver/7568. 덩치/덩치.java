import java.io.*;
import java.util.*;


public class Main {
    /* 덩치 기준으로 등수를 매기는 문제
    몸무게 x 키 y -> (x,y)
    몸무게, 키 둘 다 크다면 덩치가 큰거
    하나는 크고 하나는 작으면 비교 불가 (같은 순위)
    한 집단에서 덩치가 큰 사람 기준으로 순위를 매긴다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());


        int[][] dungchi = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dungchi[i][0] = Integer.parseInt(st.nextToken());
            dungchi[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] rank = new int[N];

        for (int i = 0; i < N; i++) {
            rank[i] = 1;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (dungchi[i][0] < dungchi[j][0] && dungchi[i][1] < dungchi[j][1]) {
                    rank[i]++;
                }
            }
        }

        for (int i : rank) {
            bw.write(i + " ");
        }
        bw.flush();
    }
}
