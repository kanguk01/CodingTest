import java.io.*;
import java.util.*;


public class Main {
    /**
     * 숫자 야구 룰에 맞추어 주어진 조건에 성립하는지 체크한다.
     * 123~987까지 다 탐색한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            input[i][2] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 123; i < 988; i++) {
            if (ispossiblenumber(i, input)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    /**
     * 주어진 수의 스트라이크 볼을 구해서
     * 문제에 주어진 스트라이크, 볼과 같으면 통과
     */
    public static boolean ispossiblenumber(int number, int[][] input) {
        String numbertostring = Integer.toString(number);

        //0이 포함되거나 같은 수가 있으면 컷
        if (numbertostring.charAt(0) == numbertostring.charAt(1) ||
                numbertostring.charAt(1) == numbertostring.charAt(2) ||
                numbertostring.charAt(0) == numbertostring.charAt(2)) {
            return false;
        }
        if (numbertostring.charAt(0) == '0' || numbertostring.charAt(1) == '0' || numbertostring.charAt(2) == '0') {
            return false;
        }
        for (int[] checkinput : input) {
            int guess = checkinput[0];
            int expectedStrikes = checkinput[1];
            int expectedBalls = checkinput[2];

            int strikes = 0;
            int balls = 0;

            String guessStr = Integer.toString(guess);

            // 스트라이크와 볼 체크
            for (int i = 0; i < 3; i++) {
                if (numbertostring.charAt(i) == guessStr.charAt(i)) {
                    strikes++;
                } else if (numbertostring.contains(String.valueOf(guessStr.charAt(i)))) {
                    balls++;
                }
            }

            if (strikes != expectedStrikes || balls != expectedBalls) {
                return false;
            }
        }
        return true;
    }

}
