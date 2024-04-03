import java.util.*;

class Solution {
    public String solution(String number, int k) {
        /*
        스택에 넣다가 지금 넣으려는 수가 지금 맨 위에있는 수보다 크면 위에있는수 pop
        쭉쭉 처리한다.
        */
        Stack<Character> num = new Stack<>();
        int remove = k;
        num.push(number.charAt(0));
        for(int i=1; i<number.length(); i++){
            while(!num.isEmpty()&&remove>0&&Character.compare(num.peek(),number.charAt(i))<0){
                num.pop();
                remove--;
            }
            num.push(number.charAt(i));
        }
        if(remove>0){ //삭제해야 할 횟수가 남아있다면 끝에서부터 그냥 삭제함
            for(int i=0; i<remove; i++){
                num.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!num.isEmpty()){
            sb.append(Character.toString(num.pop())); //char니까 String으로
        }
        
        return sb.reverse().toString();
    }
}