import java.util.*;

/*
키를 돌리고 다 넣어보면 됨

000
100
011 ->

M = 3
i j -> j / M - (i + 1)
0,0 -> 0,2
0,1 -> 1,2
0,2 -> 2,2
1,0 -> 0,1
1,1 -> 1,1
1,2 -> 2,1
2,0 -> 0,0
2,1 -> 1,0
2,2 -> 2,0
*/

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int N = lock.length;
        int M = key.length;
        int bigLength = 2 * M + N;
        int[][] bigLock = new int [bigLength][bigLength]; //확장된 키를 만들고
        for(int i = 0; i < bigLength; i++){ // 확장키 외부영역을 -1로 채움
            for(int j=0; j< bigLength; j++){
                bigLock[i][j] = -1;
            }
        }
        
        for(int i = 0; i < N; i++){ // 가운데에 기존 자물쇠를 박음
            for(int j=0; j<N; j++){
                bigLock[i + M][j + M] = lock[i][j];
            }
        }
        for(int i = 0; i < 4; i++){ // 90도씩 4번 돌리고
            key = rotate(key);
            if(fit(bigLock, key)) {
                return true;
            }
            
        }
        return answer;
    }
    
    private int[][] rotate (int[][] key) { // 시계방향으로 90도 회전
        int M = key.length;
        int[][] rotateKey = new int[M][M];
        for(int i=0; i<M; i++) {
            for(int j=0; j<M; j++) {
                rotateKey[j][M-1-i] = key[i][j];
            }
        }
        return rotateKey;
    }
    
    private boolean fit (int[][] bigLock, int[][] key) {
        int N = bigLock.length;
        int M = key.length; 
        int hole = 0;
        
        for(int i = 0; i < N; i++){ // 자물쇠에서 채워야하는 구멍의 수
            for(int j=0; j<N; j++){
                if(bigLock[i][j] == 0) {
                    hole++;
                }
            }
        }
                
        for(int x = 0; x <= N - M; x++) {
            for(int y=0; y<=N - M; y++){
                int fitNum = 0;
                boolean isValid = true;
                for(int i=0; i<M; i++) {
                    for(int j=0; j<M; j++){
                        if(bigLock[i + x][j + y] == -1) continue;
                        if(key[i][j] == 1 && bigLock[i + x][j + y] == 0){
                            fitNum++;
                        }
                        if(key[i][j] == 1 && bigLock[i + x][j + y] == 1){
                            isValid = false;
                        }
                                                                    
                    }
                }
                if(hole == fitNum && isValid) return true;
            }
        }
            
        
        return false;   
    }
}
