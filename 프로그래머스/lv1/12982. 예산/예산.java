import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        
        int temp = 0;
        for(int i=0; i<d.length; i++){
            temp+=d[i];
            
            if(temp>budget){
                answer=i;
                break;
            }
            answer = i+1;
        }
        return answer;
    }
}