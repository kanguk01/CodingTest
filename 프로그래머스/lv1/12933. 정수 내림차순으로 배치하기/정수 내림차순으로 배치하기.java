import java.util.*;

class Solution {
    public long solution(long n) {
        String[] ans = String.valueOf(n).split("");
        Arrays.sort(ans);
        
        StringBuilder sb = new StringBuilder();
        
        for(String tmp : ans){
            sb.append(tmp);
        }
        
      return Long.parseLong(sb.reverse().toString());
    }   
}