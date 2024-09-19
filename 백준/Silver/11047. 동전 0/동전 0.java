import java.io.*;
import java.util.*;


public class Main {
    /* 필요한 동전 개수의 최솟값을 구하는 문제
    첫 줄에 N과 K가 주어진다.
    그 다음줄부터 N개의 줄로 자기가 가진 동전 종류를 오름차순으로 입력한다.
    
    현재 남은 가격에서 가장 큰 동전부터 빼면 된다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int goal = K;
        int maxcoin = N - 1;
        while (goal != 0) {
            while (goal < coin[maxcoin]) {
                maxcoin--;
            }
            goal -= coin[maxcoin];
            answer++;
        }
        System.out.println(answer);
    }
}
