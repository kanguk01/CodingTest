import java.io.*;
import java.util.*;


public class Main {
    /*
    햄버거 분배

    K는 최대 거리, 사람은 K 이하의 거리에 있는 햄버거를 먹을 수 있음

    <입력>
    첫 줄에 식탁의 길이 N, 최대 거리 K
    다음 줄에 H와 P 정보 주어짐

    <출력>
    햄버거를 먹을 수 있는 사람 수
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        char[] table = new char[N];

        st = new StringTokenizer(br.readLine());
        String tableString = st.nextToken();
        for (int i = 0; i < N; i++) {
            table[i] = tableString.charAt(i);
        }
        for (int i = 0; i < N; i++) {
            if (table[i] == 'P') {
                int leftDtistance = Math.min(i, K);
                int rightDtistance = Math.min(N-i-1, K);

                for (int j = -leftDtistance; j <= rightDtistance; j++) {
                    if (table[i + j] == 'H') {
                        answer++;
                        table[i + j] = 'E';
                        break;
                    }
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}
