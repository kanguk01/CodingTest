
class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        String fir = "";
        String Aft = "";
        
        for (int i = 0; i<s; i++) {
        	fir += my_string.charAt(i);
        	
        }
        
        for (int j = s+(overwrite_string.length()); j<my_string.length(); j++) {
        	Aft += my_string.charAt(j);
        	
        }
        
        answer = fir+overwrite_string + Aft;
        
        return answer;
        
    }
}