import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        stack.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
        	if(stack.peek()!=arr[i]) {
        		stack.add(arr[i]);
        	}
        	
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        int[] answer = new int[stack.size()];
        for(int j=stack.size()-1; j>=0; j--) {
        	answer[j]= stack.pop();
        }

        return answer;
    }
}