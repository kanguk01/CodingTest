import java.io.*;
import java.util.*;


public class Main {
    /* 강의실 최대 인원 구하는 문제
    H : 행
    W : 행마다 W개씩 테이블이 있다.
    N : 세로로 비워야 하는 칸
    M : 가로로 비워야 하는 칸

    세로줄 차가 N보다 크거나 가로줄 차가 M보다 큰 곳에만 앉을 수 있다.
    그리고 시간복잡도가 N^2이 된다면 안된다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int hCount = 1;
        int wCount = 1;
        int hMax = 1;
        int wMax = 1;

        while (H >= hCount) {
            hCount += N + 1;
            if (H >= hCount) {
                hMax++;
            }
        }

        while (W >= wCount) {
            wCount += M + 1;
            if (W >= wCount) {
                wMax++;
            }
        }

        bw.write(hMax * wMax + "");
        bw.flush();
    }
}
