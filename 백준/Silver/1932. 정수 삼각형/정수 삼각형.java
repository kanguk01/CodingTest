import java.io.*;
import java.util.*;


public class Main {
    /**
     * DP
     * triandle[i-1][j] = max(triangle[i][j], triangle[i][j+1]) 을 계속 찾으면 된다.
     * 근데 삼각형의 아래에서 위로 올라오면서 하면 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N][N];

        for (int i = 0; i < N; i++) { // 삼각형 만들어주기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=triangle.length-1; i > 0; i--) { //삼각형 아래에서부터 최댓값 찾아준다.
            for (int j=0; j < triangle[i].length-1; j++) {
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }
        System.out.println(triangle[0][0]);
    }
}
