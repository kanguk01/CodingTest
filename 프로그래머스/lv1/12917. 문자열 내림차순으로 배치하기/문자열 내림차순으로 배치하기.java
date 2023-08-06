import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String[] Arr = s.split("");
        Arrays.sort(Arr, Collections.reverseOrder());
               
        
        return String.join("",Arr);
    }
}