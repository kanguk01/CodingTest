import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        
        Stack<Integer> num = new Stack<>(); //stack 이용하기위해 선언
        num.push(arr[0]); //첫번째는 무조건 안겹칠거니까 그냥 바로 넣어줌
        
        for(int i=1; i<arr.length; i++){ //어차피 바로 뒤 숫자니까 stack에서 Peek한게 같다면 스택에 Push
            if(num.peek() != arr[i]) {
                num.push(arr[i]);
            }
        }
        
        int[] answer = new int[num.size()]; //스택 내에 값들을 배열로 전환
        for(int i=num.size()-1; i>=0; i--){
            answer[i] = num.pop();
        }
        

        return answer;
    }
}