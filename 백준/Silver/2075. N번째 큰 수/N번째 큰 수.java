import java.io.*;
import java.util.*;


public class Main {
    /*
    N번째 큰 수

    N * N 의 표에 수가 있다.
    이 수들은 자신의 한 칸 위에 있는 수보다 크다

    이때, N번째 큰 수를 찾아라

    첫 줄 : N
    둘째 줄 이후 : 표 숫자들 쫘라락

    N <= 1500 이므로 1,500,000 -> 최대 시간복잡도는 대략 NlogN
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> table = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table.offer(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < N - 1; i++) {
            table.poll();
        }
        bw.write(table.poll() + "");

        bw.flush();
    }
}