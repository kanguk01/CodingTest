import java.io.*;
import java.util.*;


public class Main {
    /*
    블로그

    X일 동안 가장 많이 들어온 방문자 수와 기간이 몇 개 있는지
    첫째 줄 : 블로그를 시작하고 지난 일수 N X
    둘째 줄 : 블로그 시작 1일차부터 N일차까지 하루 방문자 수 공백으로 구분

    N^2 시간복잡도로 풀면 시간초과

    출력
    첫 줄 : X일 동안 가장 많이 들어온 방문자 수 출력, 만약 0 이라면 SAD 출력
    두번째 줄 : 최대 방문자 수가 0명이 아닌 경우 기간이 몇 개 있는지 출력

    17:10 시작
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int visitor[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitor[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int max = 0;
        int count = 0;

        for (int i = 0; i < X; i++) {
            sum += visitor[i];
        }

        max = sum;
        count++;

        for (int i = 0; i < N  - X; i++) {
            sum = sum - visitor[i] + visitor[i + X];

            if (sum > max) {
                max = sum;
                count = 1;
            } else if (sum == max) {
                count++;
            }
        }
        if(max == 0){
            bw.write("SAD\n");
            bw.flush();
            return;
        }
        bw.write(max + "\n" + count);
        bw.flush();
    }
}
