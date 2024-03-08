import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        /*
        스택을 이용하여 간단하게 처리가능
        여는 괄호일때는 push하고 닫는 괄호일때는 pop한다
        마지막에 스택이 Empty면 true
        */
        Stack<Character> pair = new Stack<>();
        if(s.charAt(0) == ')') return false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') pair.push(s.charAt(i));
            else {
                if(pair.isEmpty()) return false;
                pair.pop();
            }
        }
        if(!pair.isEmpty()) answer = false;

        return answer;
    }
}