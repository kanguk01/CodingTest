import java.io.*;
import java.util.*;


public class Main {
    /**
     * 1로 만들기
     * DP
     * 2,3으로 나누어 떨어질때는 dp[i/3]+1, dp[i/2]+1
     * 나누어 떨어지지 않을 때는 dp[i-1]+1
     * 이를 종합하여 점화식으로 구현하면 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X + 1];
        dp[1] = 0;

        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[X]);
    }
}
