import java.util.*;

public class Main {
    /**
     * A, B, V 가 주어짐
     * A만큼 올라가고 B만큼 내려옴
     * V만큼 올라가려면 며칠 드나?
     * while -> 시간초과난다. 다른 방법으로 해야함
     * 첫날 A만큼 올라가고 A-1, A-2... A-B 까지 떨어진다.
     * 달팽이가 마지막 날에 정상에 올라가면, 그 전날엔 V - B만큼 올라간다.
     * 그 이후에는 미끄러지지 않으므로 결국 V-B만큼 올라가면 된다.
     * 올림하여 마지막 처리
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt(); // 입력값 받고
        int answer = (V - B - 1) / (A - B) + 1;

        System.out.println(answer);
    }
}
