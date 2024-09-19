import java.io.*;
import java.util.*;


public class Main {
    /* 문자열의 첫글자와 마지막 글자를 출력하는 프로그램
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            char first = input.charAt(0);
            char last = input.charAt(input.length() - 1);
            System.out.println(first + "" + last);
        }
    }
}
