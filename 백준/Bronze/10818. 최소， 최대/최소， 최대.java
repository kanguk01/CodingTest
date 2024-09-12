import java.io.*;
import java.util.*;


public class Main {
    /* N개의 정수가 주어지면, 최솟값과 최댓값을 구하는 문제
    첫째 줄에는 정수의 개수 N
    그 이후로 정수를 공백으로 구분하여 제시
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstnumber = Integer.parseInt(st.nextToken());
        int max = firstnumber;
        int min = firstnumber;

        for (int i = 1; i < N; i++) {
            int tempnumber = Integer.parseInt(st.nextToken());
            if (tempnumber > max) {
                max = tempnumber;
            }
            if (tempnumber < min) {
                min = tempnumber;
            }
        }

        System.out.println(min + " " + max);
    }
}
