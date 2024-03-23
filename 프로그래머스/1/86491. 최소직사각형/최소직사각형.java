import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        /* 1135
        모든 명함을 수납할 수 있는 사이즈중
        최솟값을 리턴한다.
        
        큰 길이를 한쪽으로 모두 몰고 
        최소한의 크기를 구하면 된다..
        */
        int curbig = 0;
        int cursmall = 0;
        for(int[] size : sizes){
            int big = Math.max(size[0], size[1]);
            int small = Math.min(size[0], size[1]);
            
            curbig = Math.max(curbig, big);
            cursmall = Math.max(cursmall, small);
        }
        return curbig * cursmall;
    }
}