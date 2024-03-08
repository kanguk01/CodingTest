import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        /*
        앞 기능부터 배포가 가능하다.
        각 기능의 배포가 가능한 일자를 먼저 도출해 낸 후 배열로 담아둔다.
        */
        int size = progresses.length;
        int[] deploy = new int[size];
        
        for(int i=0; i<size; i++){
            int tmp = 1;
            int day = 1;
            while(tmp < 100){
                tmp = progresses[i] + speeds[i] * day;
                day++;
            }
            deploy[i] = day;
        }
        /*
        {5,10,1,1,20,1} 이라면 {1,3,2} 가 돼야한다
        스택에 다 집어넣는다
        
        <stack>
        5
        10
        1
        1
        20
        1
        
        pop을 하는데 그 다음수가 처음 Pop 한 수보다 클때까지 연속으로 pop 하고 그 수를 카운트한다
        그리고 카운트 된 수를 배열에 넣어준다.
        */
        Stack<Integer> deployday = new Stack<>(); //stack 생성
        for(int i=size-1; i>=0; i--){
            deployday.push(deploy[i]);
        }
        
        ArrayList<Integer> pop = new ArrayList<>(); //카운트 된 수를 배열에 넣어주기 위해 일단 arraylist 사용
        while(!deployday.isEmpty()){ //처음 Pop한 수보다 클때까지 계속 Pop
            int tmp = deployday.pop();
            int count = 1;
            while(!deployday.isEmpty()&&tmp>=deployday.peek()){
                deployday.pop();
                count++;
            }
            pop.add(count);
        }
        int[] answer = new int[pop.size()]; //arraylist 를 list배열로 바꿔서 출력
        for(int i=0; i<pop.size(); i++){
            answer[i] = pop.get(i);
        }
        return answer;
    }
}