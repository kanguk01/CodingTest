import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new HashSet[9]; // N을 사용하는 횟수마다 가능한 숫자의 집합을 저장할 배열

        for (int i = 1; i <= 8; i++) {
            // i번째 숫자를 만드는 경우의 수 저장하는 Set 생성
            dp[i] = new HashSet<>();
            // N을 i번 사용하는 경우, NNNN...NN (i번 반복)을 추가
            dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));

            // j를 1부터 i-1까지 순회하여 dp[j]와 dp[i-j]의 모든 조합을 사칙연산하여 dp[i]에 추가
            for (int j = 1; j < i; j++) {
                for (int num1 : dp[j]) {
                    for (int num2 : dp[i - j]) {
                        dp[i].add(num1 + num2);
                        dp[i].add(num1 - num2);
                        dp[i].add(num1 * num2);
                        if (num2 != 0) dp[i].add(num1 / num2);
                    }
                }
            }

            // number가 dp[i]에 포함되어 있으면 i를 리턴
            if (dp[i].contains(number)) return i;
        }

        // 최솟값이 8보다 크면 -1을 리턴
        return -1;
    }
}
