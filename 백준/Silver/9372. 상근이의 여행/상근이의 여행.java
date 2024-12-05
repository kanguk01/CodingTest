import java.io.*;
import java.sql.Array;
import java.util.*;


public class Main {
    /*
    첫 번째 줄 - 테스트 케이스의 수 T
    그 이후
    N , M (N = 나라의 수, M = 비행기의 수)
    그리고 M 만큼 비행기의 정보 출력
    N 나라를 모두 여행하기 위한 비행기 수를 출력
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> airplane = new ArrayList<>();

            for (int k = 0; k <= N; k++) { // 빈 그래프 만들고
                airplane.add(new ArrayList<>());
            }

            for (int j = 0; j < M; j++) { // 그래프 만들기
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                airplane.get(a).add(b);
                airplane.get(b).add(a);
            }

            bw.write(N - 1+ "\n");
        }

        bw.flush();
    }
}
