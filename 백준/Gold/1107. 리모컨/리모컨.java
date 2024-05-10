import java.util.*;

public class Main {
    static boolean[] brokenButtons = new boolean[10];

    // 주어진 숫자가 고장난 버튼을 사용하는지 확인하는 함수
    static boolean isPossible(int number) {
        if (number == 0) {
            return brokenButtons[0] ? false : true;
        }
        while (number > 0) {
            if (brokenButtons[number % 10]) {
                return false;
            }
            number /= 10;
        }
        return true;
    }

    // 현재 채널에서 목표 채널로 이동하는데 필요한 버튼을 누르는 함수
    static int pressButtons(int channel) {
        int count = 0;
        if (channel == 0) {
            return isPossible(channel) ? 1 : Integer.MAX_VALUE;
        }
        while (channel > 0) {
            if (!isPossible(channel % 10)) {
                return Integer.MAX_VALUE;
            }
            count++;
            channel /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 이동하려는 채널
        int M = scanner.nextInt(); // 고장난 버튼의 개수

        for (int i = 0; i < M; i++) {
            int button = scanner.nextInt();
            brokenButtons[button] = true;
        }

        // 현재 채널은 100이므로, 100에서 N으로 바로 이동하는 경우와
        // 숫자 버튼만을 이용해 이동하는 경우 중 최소값을 선택합니다.
        int minCount = Math.abs(N - 100);

        // 숫자 버튼만을 이용해 이동하는 경우
        for (int i = 0; i <= 1000000; i++) {
            int count = pressButtons(i);
            if (count != Integer.MAX_VALUE) {
                minCount = Math.min(minCount, Math.abs(N - i) + count);
            }
        }

        System.out.println(minCount);
    }
}
