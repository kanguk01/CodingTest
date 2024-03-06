import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sizelim = nums.length/2;
        HashSet<Integer> ponket = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            if(!ponket.contains(nums[i]) && ponket.size()<sizelim){
                ponket.add(nums[i]);
            }
        }
        return ponket.size();
    }
}