class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        String tempA = "";
        String tempB = "";
        for(int i=0; i<A.length(); i++){
            for(int j=0; j<B.length(); j++){
                    tempA= B.substring(0,j);                    
                    tempB= B.substring(j);
                    

                    
                    String tempC= tempB+tempA;
                    
                    if(A.equals(tempC)){
                        return j-i;
                    }
                    else{continue;}
                }
            }
        
        return answer;

    }
    
    public static void main(String args[]) {
    	Solution st = new Solution();
    	System.out.println(st.solution("hello","ohelq"));
    }
}