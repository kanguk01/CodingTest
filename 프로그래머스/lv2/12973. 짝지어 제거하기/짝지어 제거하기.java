import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<String> tmp = new Stack<>();
        tmp.push(String.valueOf(s.charAt(0)));
        
        for(int i=1; i<s.length(); i++){
            if(tmp.empty()){
                tmp.push(String.valueOf(s.charAt(i)));
            }
            else{
                if((tmp.peek()).equals(String.valueOf(s.charAt(i)))){
                    tmp.pop();
                }
                else{
                    tmp.push(String.valueOf(s.charAt(i)));
                }
            }
        }
        
        if(tmp.empty()){answer = 1;}
        else{answer = 0;}

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        return answer;
    }
}