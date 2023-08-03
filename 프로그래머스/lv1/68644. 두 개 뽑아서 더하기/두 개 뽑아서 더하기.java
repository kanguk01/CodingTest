import java.util.ArrayList;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<numbers.length-1; i++){
            for(int j=0; j<numbers.length; j++){
                if(i!=j&&!ans.contains((numbers[i]+numbers[j]))){
                    ans.add((numbers[i]+numbers[j]));
                }
            }
        }
        int[] answer = new int[ans.size()];
        
        for(int i=0; i<ans.size(); i++){
            answer[i]=ans.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}