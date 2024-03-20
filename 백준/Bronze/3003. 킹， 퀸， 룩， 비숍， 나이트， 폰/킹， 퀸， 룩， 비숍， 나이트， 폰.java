import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 주어진 입력에서 흰색 피스의 개수를 입력받습니다.
        int[] whitePieces = new int[6];
        for (int i = 0; i < 6; i++) {
            whitePieces[i] = scanner.nextInt();
        }
        
        // 올바른 흰색 피스의 개수를 저장합니다.
        int[] correctPieces = {1, 1, 2, 2, 2, 8};
        
        // 더하거나 빼야 하는 개수를 계산합니다.
        for (int i = 0; i < 6; i++) {
            int diff = correctPieces[i] - whitePieces[i];
            System.out.print(diff + " ");
        }
        
        scanner.close();
    }
}
