import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        /*
        단순하게 보면 n^2으로 돌면 되긴하겠지만 무조건 시간초과가 날 것 같다.
        상승장일때는 가격이 안떨어지는것이므로 쭉 저장을 해준다(자동으로 오름차순이 된다.)
        그러다가 하락장이 온 순간 그 가격이랑 비교하면서 가격이 떨어진애들을 쳐낸다
        끝까지 갔는데 살아있는애가 있으면 한번도 안떨어진거다.
        +스택에 리스트를 저장한다.
        저장값: {가격, index}
        */
        int size = prices.length;
        int[] answer = new int[size]; //정답을 저장할 array
        Stack<int[]> money = new Stack<>(); //스택에 저장  
        int[] data = {prices[0], 0};
        money.push(data); //처음값은 무조건 저장
        
        for(int i=1; i<size; i++){
            if(!money.isEmpty()&&prices[i]>=money.peek()[0]){ //상승장이라면
                data = new int[]{prices[i], i};
                money.push(data); //스택에 저장
            }
            /*
            하락장이 시작하면 시작한 기준 가격과 지금까지 저장했던 돈을 비교해서 현재 가격보다 '클때만' pop시킨다.
            pop하면서 count를 늘리면, 그 count는 가격이 떨어지지 않던 초가 된다.
            그 값을 arraylist 해당 인덱스에 넣어준다.
            */
            else if(money.isEmpty()){ //스택이 비어있을때 하락해버리면 
                answer[i-1] = 1;
            }
            else{
                int tmp = i;
                int count = 0;
                while(!money.isEmpty()&&prices[i]<money.peek()[0]){//하락장이 시작하면 한번 정리해준다
                    int tempidx= money.pop()[1];
                    tmp--;
                    count++;
                    answer[tempidx] = i-tempidx;
                }
                data = new int[]{prices[i], i};
                money.push(data);
            }
        }
        /*
        다 돌았는데 answer에 0이 있다면, 그건 끝까지 떨어지지않은 애들이다
        */
        for(int i = 0; i<size; i++){
            if(answer[i] == 0){
                answer[i] = size - 1 - i;
            }
        }
        return answer;
    }
}