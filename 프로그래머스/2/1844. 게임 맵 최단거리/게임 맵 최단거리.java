import java.util.*;

/*
경로 찾기 

출발점은 0,0
목표점은 n,m

최단 경로를 찾아야함 -> BFS

1:30
*/

class Solution {
    private int[] dx = {0, 0, -1, 1}; // 상하좌우
    private int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length; // 행 길이
        int m = maps[0].length; // 열 길이
        int[][] answer = new int[n][m];
        
        Queue<int[]> bfs = new LinkedList<>();
        answer[0][0] = 1; 
        bfs.offer(new int[]{0,0});
        
        while(!bfs.isEmpty()){
            int[] cur = bfs.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for(int i = 0; i<4; i++){
                int aX = curX + dx[i];
                int aY = curY + dy[i];
                
                if(aX < 0 || aY < 0 || aX >= n || aY >= m){
                    continue;
                }
                
                if(maps[aX][aY] == 1 && answer[aX][aY] == 0){
                    answer[aX][aY] = answer[curX][curY] + 1;
                    bfs.offer(new int[]{aX,aY});                   
                }                
            }
        }
        if(answer[n-1][m-1] == 0) return -1;
        return answer[n-1][m-1];
    }
}