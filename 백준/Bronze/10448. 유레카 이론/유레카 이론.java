import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * K가 1000 이하니까 1000까지의 모든 삼각수를 다 구한다.
     * 그리고 주어진 수가 3개의 삼각수들끼리의 합으로 표시되는지 찾으면 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] testCases = new int[T];

        for (int i = 0; i < T; i++) {
            testCases[i] = Integer.parseInt(br.readLine());
        }

        int[] triangleNumbers = new int[45]; // 45 * 46 / 2 = 1035 이므로 45까지
        for (int i = 1; i < 45; i++) {
            triangleNumbers[i] = i * (i + 1) / 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int testCase : testCases) {
            sb.append(threetrianglenumbersum(testCase, triangleNumbers) ? 1 : 0).append('\n');
        }

        System.out.print(sb.toString());
    }

    public static boolean threetrianglenumbersum(int number, int[] triangleNumbers){
        for (int i = 1; i < 45; i++) {
            for (int j = 1; j < 45; j++) {
                for (int k = 1; k < 45; k++) {
                    if (triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[k] == number) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
