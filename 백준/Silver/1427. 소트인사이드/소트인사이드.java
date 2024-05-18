import java.io.*;
import java.util.*;


public class Main {
    /**
     * 수가 주어진다 (10억이하)
     * 그 수를 내림차순으로 정렬해서 출력한다. (1234 -> 4321)
     * 형변환에 신경
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        String[] numberarray = new String[number.length()];

        for (int i = 0; i < numberarray.length; i++) {
            numberarray[i] = String.valueOf(number.charAt(i));
        }
        Arrays.sort(numberarray, Collections.reverseOrder());

        for (String s : numberarray) {
            System.out.print(s);
        }
    }
}
