import java.io.*;
import java.util.*;


public class Main {
    /*
    KCPC

    등수를 구해야함

    <입력>
    첫 줄 : 테스트 데이터 T 개
    두번째 줄 : 팀의 개수 n, 문제의 개수 k, 내 팀 ID t, 로그 엔트리의 개수 m
    이후 : m개의 줄 -> 각 풀이에 대한 정보가 제출 순서대로
        팀 ID i, 문제 번호 j, 획득한 점수 s

    21:45
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            if(input == 0){
                if(!minHeap.isEmpty()){
                    bw.write(minHeap.poll() + "\n");
                } else {
                    bw.write("0" + "\n");
                }
            } else {
                minHeap.offer(input);
            }
        }

        bw.flush();
    }
}