import java.util.*;

class Solution {
    public int solution(int n) {
        Stack<Integer> three = new Stack<Integer>();
        int answer = 0;
        int count = 0;
        int tmp = n;
        while(tmp!=0){
            three.push(tmp%3);
            tmp = tmp/3;
            count++;
        }
        
        for(int i=0; i<count; i++){
            answer += ((int)(Math.pow(3,i)))*three.pop();
        }
        return answer;
    }
}