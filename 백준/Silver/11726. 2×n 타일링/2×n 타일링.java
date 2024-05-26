import java.io.*;
import java.util.*;


public class Main {
    /**
     * 2*n 타일링
     * DP
     * 그 전까지는 다 똑같다가 마지막-1과 마지막-2 타일만 달라지므로 
     * 점화식 : dp[i] = dp[i-1] + dp[i-2]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
