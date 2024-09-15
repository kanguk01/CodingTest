import java.io.*;
import java.util.*;


public class Main {
    /* 알파벳을 입력한다.
    1은 2초, 2부터는 3초, 4초, 5초...
    ABC - 2
    DEF - 3 ...
    WXYZ - 9
    총 걸리는 시간 출력
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        // 각 알파벳에 맞는 시간 매칭
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int[] time = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
        
        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            char tempalphabet = word.charAt(i);
            for (int j = 0; j < 26; j++) {
                if (tempalphabet == alphabet[j]) {
                    answer += time[j];
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
