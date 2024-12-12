import java.io.*;
import java.util.*;


public class Main {
    /*
    예산
    요구하는 예산이 있고
    최대 예산이 있다.

    예산이 부족하지 않으면 그냥 다 주고 (최댓값 출력)
    부족하면 상한가를 지정하여 예산에 딱 맞도록 한다.
    예산의 최댓값은?
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] budget = new int[N];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            sum += budget[i];
        }
        Arrays.sort(budget);

        int maximum = Integer.parseInt(br.readLine());

        if(sum <= maximum) {
            bw.write(budget[N-1] + "\n");
            bw.flush();
            return;
        }

        int start = 0;
        int end = budget[N-1]; // 최대 상한액
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int total = 0;

            for(int i : budget) {
                total += Math.min(i, mid); // 상한액보다 크면 상한액까지만
            }

            if(total > maximum) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        bw.write(result + "\n");
        bw.flush();
    }
}
