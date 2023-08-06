class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length()==4||s.length()==6){
        
            for(int i= 0; i<s.length(); i++){
                if(!(s.charAt(i)-48<=9)){answer = false;}
            }
        }
        
        else {return false;}
        
        return answer;
    }
}