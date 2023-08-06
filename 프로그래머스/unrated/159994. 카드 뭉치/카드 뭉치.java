import java.util.Stack;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Stack<String> cd1 = new Stack<>();
        Stack<String> cd2 = new Stack<>();
        cd1.push(" ");
        cd2.push(" ");
        
        for(int i=cards1.length-1; i>=0; i--){
            cd1.push(cards1[i]);
        }
        
        for(int i=cards2.length-1; i>=0; i--){
            cd2.push(cards2[i]);
        }
        
        for(int i = 0; i<goal.length; i++){
            if(cd1.peek().equals(goal[i])){cd1.pop();}
            else if(cd2.peek().equals(goal[i])){cd2.pop();}
            else{answer = "No";}
        }
        return answer;
    }
}