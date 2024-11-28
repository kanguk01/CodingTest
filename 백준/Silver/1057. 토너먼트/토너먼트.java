import java.io.*;
import java.util.*;


public class Main {
    /*
    토너먼트
    인접한 번호끼리 싸움
    홀수명 참가 - 마지막 번호 부전승
    한 라운드마다 번호를 다시 매김
    김지민과 임한수는 몇 라운드에서 만날까 (만나기 전까지는 항상 이김)
    참가자수 N, 김지민, 임한수
    O(n^2)이 되면 안된다.
    12 34 56 78 910
    1 3 6 7 9
    12 34 5
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Kim = Integer.parseInt(st.nextToken());
        int Im = Integer.parseInt(st.nextToken());
        int round = 0;

        while (Kim != Im) {
            Kim = (Kim + 1) / 2;
            Im = (Im + 1) / 2;
            round++;
        }

        bw.write(round + "\n");
        bw.flush();
    }
}
