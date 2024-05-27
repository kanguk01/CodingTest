import java.io.*;
import java.util.*;


public class Main {
    /**
     * 계단 오르기
     * 첫째 줄에는 계단의 개수
     * 그다음부터는 계단 수
     * 계단은 한칸 혹은 두칸을 오를수 있는데, 연속으로 3개를 오를 수는 없다.
     * 마지막 칸은 무조건 밟아야 한다.
     * 마지막 계단이 i라고 하면, i-1을 밟는 경우와 i-2를 밟는 경우 두 가지 존재한다.
     * i-1을 밟은 경우 -> 그 전은 무조건 i-3이여야함
     * i-2를 밟은 경우 -> i-3, i-4 둘 중 하나이다.
     * 점화식 : dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n + 1];
        int[] stairs = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];

        if (n > 1) {
            dp[2] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }
        System.out.println(dp[n]);

    }
}
