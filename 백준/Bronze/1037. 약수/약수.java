import java.io.*;
import java.util.*;


public class Main {
    /* N의 진짜 약수가 모두 주어질 때 N을 출력해라
    첫 줄에 N의 진짜 약수의 개수 count
    둘째 줄에 N의 진짜 약수가 주어진다. 2<=N<=백만
    진짜 약수 : A가 N 의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니여야 함.
    즉, 1과 자기 자신을 제외한 수가 진짜 약수이다.

    진짜 약수의 최솟값과 최댓값을 곱하면 되는것 아닌가? 만약 하나라면 그 수의 제곱수를 출력한다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 1000000;
        int max = 2;

        for (int i = 0; i < count; i++) {
            int tempnumber = Integer.parseInt(st.nextToken());
            if (min > tempnumber) {
                min = tempnumber;
            }
            if (max < tempnumber) {
                max = tempnumber;
            }
        }

        System.out.println(min * max);
    }
}
