import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main{
    /**
     * N * M 의 블럭의 모든 높이를 일정하게
     * 땅을 파는건 2초, 놓는건 1초
     * 일단 이차원배열로 땅 정보를 저장
     * 가능한 모든 높이에 대해 시간 계산하고 최소시간의 경우 선택
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer N = Integer.parseInt(st.nextToken());
        Integer M = Integer.parseInt(st.nextToken());
        Integer B = Integer.parseInt(st.nextToken());
        int[][] ground = new int[N][M];
        int min = 256;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                if (ground[i][j] < min) {
                    min = ground[i][j];
                }
                if (ground[i][j] > max) {
                    max = ground[i][j];
                }
            }
        }
        int minTime = Integer.MAX_VALUE;
        int optimalHeight = 0;
        for(int height = min; height <= max; height++){ // 최소높이부터 최대높이까지 다 확인
            int build = 0;
            int destroy = 0;
            int currentInventory = B;
            for (int i = 0; i < N; i++) { // 2차원배열 생성
                for (int j = 0; j < M; j++) {
                    if(ground[i][j] < height){ // 쌓아야 하는상황
                        build += height - ground[i][j];
                        currentInventory -= height - ground[i][j];
                    } else if (ground[i][j] > height) { // 부셔야 하는상황
                        destroy += ground[i][j] - height;
                        currentInventory += ground[i][j] - height;
                    }
                }
            }
            if (currentInventory < 0) continue; // 인벤토리 블럭이 부족하면 그냥 버림
            int time = destroy * 2 + build;
            if (time < minTime) {
                minTime = time;
                optimalHeight = height;
            } else if (time == minTime && height > optimalHeight) {
                optimalHeight = height;
            }
        }

        System.out.println(minTime + " " + optimalHeight);
    }
}
