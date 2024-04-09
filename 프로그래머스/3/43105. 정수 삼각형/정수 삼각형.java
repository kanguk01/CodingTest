import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        /*
        DP
        triandle[i-1][j] = max(triangle[i][j], triangle[i][j+1]) 을 계속 찾으면 된다.
        근데 삼각형의 아래에서 위로 올라오면서 하면 된다.
        */
        for (int i=triangle.length-1; i > 0; i--) {
            for (int j=0; j < triangle[i].length-1; j++) {
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }
        return triangle[0][0];
    }
}