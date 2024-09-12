import java.io.*;
import java.util.*;


public class Main {
    /* 어떤 수를 앞으로 읽어도, 뒤로 읽어도 같다면 팰린드롬 수
    각 줄에 숫자를 입력받아서 그 수가 팰린드롬수면 yes, 아니면 no 출력
    0 입력받으면 종료
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input = br.readLine();
            boolean answer = true;
            if (input.equals("0")) {
                return;
            }

            int length = input.length();

            if (length % 2 == 0) { // 길이가 짝수라면
                for (int i = 0; i < length / 2; i++) {
                    char firstnumber = input.charAt(i);
                    char secondnumber = input.charAt(length - 1 - i);

                    if (firstnumber != secondnumber) {
                        answer = false;
                        break;
                    }
                }
            } else { // 홀수라면 -1 해서 시도해야하므로
                for (int i = 0; i < length / 2; i++) {
                    char firstnumber = input.charAt(i);
                    char secondnumber = input.charAt(length - 1 - i);

                    if (firstnumber != secondnumber) {
                        answer = false;
                        break;
                    }
                }
            }

            if (answer) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
