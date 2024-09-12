class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String astring = Integer.toString(a);
        String bstring = Integer.toString(b);
        
        int first = Integer.parseInt(astring+bstring);
        int second = Integer.parseInt(bstring+astring);
        
        if(first>second){
            answer = first;
        }else {
            answer = second;
        }
        return answer;
    }
}