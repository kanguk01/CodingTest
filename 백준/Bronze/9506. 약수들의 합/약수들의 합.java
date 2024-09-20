import java.io.*;
import java.util.*;


public class Main {
    /* 입력받은 n 이 완전수인지 아닌지 판단하는 프로그램
    완전수 : 자신을 제외한 모든 약수들의 합과 본인이 같은 수 (6 = 1 + 2 + 3)
    -1 입력하면 종료
    n이 완전수라면, "6 = 1 + 2 + 3" 의 형식으로 출력
    n이 완전수가 아니라면, n is NOT perfect 출력

    그냥 약수 다 구해서 형식에 맞게 출력하면 될 것 같다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> measures = new ArrayList<>();

            if (n == -1) {
                return;
            }

            //약수 구하기
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    measures.add(i);
                }
            }

            int sum = 0;
            for (int i : measures) {
                sum += i;
            }

            if (sum == n) {
                System.out.print(n + " = ");
                for (int i = 0; i < measures.size() - 1; i++) {
                    System.out.print(measures.get(i) + " + ");
                }
                System.out.println(measures.get(measures.size()-1));
            } else {
                System.out.println(n+" is NOT perfect.");
            }
        }

    }
}
