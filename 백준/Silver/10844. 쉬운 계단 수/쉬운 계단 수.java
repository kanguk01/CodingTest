import java.io.*;
import java.util.*;


public class Main {
    /**
     * 쉬운 계단 수
     * 1234, 1232 와 같이 모든 자리의 차이가 1인 숫자를 계단 수라고 한다.
     * N이 주어지면 N자리수의 모든 계단수의 개수를 구하면 된다.
     * dp[n][d] : n 자리수의 마지막 자리가 d인 계단 수
     * dp[1][d] = 1
     * 마지막 자리가 d일때 마지막 이전 자리는 d-1혹은 d+1이 될 수 있다.
     * 따라서 점화식 :
     * d[n][d] =  d[n-1][d-1] + d[n-1][d+1]
     * 근데 d가 0 혹은 9일때는 경곗값이므로 신경써야한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int n = 2; n <= N; n++) {
            for (int d = 0; d < 10; d++) {
                if (d > 0) {
                    dp[n][d] += dp[n - 1][d - 1];
                }
                if (d < 9) {
                    dp[n][d] += dp[n - 1][d + 1];
                }
                dp[n][d] %= 1000000000;
            }
        }
        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
            result %= 1000000000;
        }
        System.out.println(result);
    }
}
