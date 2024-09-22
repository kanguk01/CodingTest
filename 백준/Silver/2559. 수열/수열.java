import java.io.*;
import java.util.*;


public class Main {
    /* 연속된 날의 합이 가장 큰 값을 출력하는 문제
    주어진 날 기준으로 합을 해서 최댓값을 출력한다.
    첫 줄에는 N 과 K가 나온다.
    N은 온도를 측정한 전체 날짜의 수이고
    K는 연속된 날을 며칠로 지정할지에 대한 수이다.

    일반적으로 하면 시간초과가 날테니 N^2이 나오지 않도록 해야한다.

    일정 구간을 이미 더해놓고 오른쪽으로 한칸씩 이동한다.
    이 때 아에 다 재계산을 하는 것이 아니라, 왼쪽걸 빼고 오른쪽걸 더한다.
    그러면 O(n) 계산 가능하다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = K - 1;
        int sum = 0;
        int answer = 0;
        for (int i = 0; i <= end; i++) {
            sum += numbers[i];
            answer = sum;
        }

        while (end < N-1) {
            sum -= numbers[start];
            start++;  // 왼쪽거는 빼주고
            end++;
            sum += numbers[end]; // 오른쪽은 더해주고

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
        
    }
}
