import java.io.*;
import java.util.*;


public class Main {
    /* 도시의 왼쪽부터 오른쪽 까지 가는 문제
    각 마을마다 주유소가 있다. (가격이 다 다름)
    그리고 길이 있다.
    최소 주유값을 구하는 문제

    첫째줄에 마을의 개수 N
    둘째줄에 마을 간 거리 (N-1 개 입력)
    셋째줄에 각 마을 주유소 가격

    그리디 문제
    쭉쭉 가다가 더 싼곳이 나오면 더 싼 가격으로 갱신한다.
    배열 끝까지 진행한다. 
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] load = new long[N-1];
        for (int i = 0; i < N - 1; i++) {
            load[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long[] village = new long[N];
        for (int i = 0; i < N; i++) {
            village[i] = Integer.parseInt(st.nextToken());
        }

        long minPrice = village[0];
        long sumPrice = 0;

        for (int i = 0; i < N - 1; i++) {
            if(village[i] < minPrice){
                minPrice = village[i];
            }
            sumPrice += load[i] * minPrice;
        }
        bw.write(sumPrice + "");
        bw.flush();
    }
}
