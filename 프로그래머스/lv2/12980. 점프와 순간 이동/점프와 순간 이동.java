import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int tmp = n;
        int jump = 1;
        while(tmp!=1){
            if(tmp%2!=0){
                tmp -= 1;
                jump += 1;
            }
            else{tmp/=2;}
        }
        
        ans = jump;

        return ans;
    }
}