import java.io.*;
import java.util.*;


public class Main {
    /* 정수 N 과 정수 X가 첫 줄에 주어진다.
    N개의 숫자로 이루어진 수열 A가 둘째줄에 주어진다.
    A 에서 X 보다 작은 수를 모두 출력
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] A = new int[N]; // 수열을 저장할 배열 선언

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (A[i] < X) {
                System.out.print(A[i] + " ");
            }
        }
    }
}
