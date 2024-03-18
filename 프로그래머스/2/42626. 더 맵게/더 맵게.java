import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        /*
        priorityQueue 이용하여 minheap 구현
        */
        int answer = 0;
        PriorityQueue<Integer> scov = new PriorityQueue<>();
        for(int i : scoville) scov.offer(i); // minheap 만들기
        /*
        heap 안에 두 개 이상의 원소가 들어가있고, 최솟값이 7이하일때 계속하여 반복
        */
        while(scov.peek() < K && scov.size()>=2){
            int tmp = scov.poll() + scov.poll()*2 ; 
            if(tmp==0) return -1; //0이라면 아무리해도 K가 안만들어질것이므로 -1리턴
            scov.offer(tmp);
            answer++;
        }
        if(scov.peek()<K) return -1; //반복문을 빠져나왔는데 작다면 -1리턴
        return answer;
    }
}