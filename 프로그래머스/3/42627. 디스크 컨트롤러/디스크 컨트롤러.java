import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        /*
        우선 순위 큐 두 개를(minheap) 사용한다. 하나는 작업들을 모두 넣고(workQ) 하나는 시점에 따라 가능한 작업을 넣는 큐이다(readyQ).
        현재 작업 가능한 큐가 있다면, 그 중 가장 소요시간이 짧은 것부터 처리한다. , 만약 작업 가능한 큐가 없다면,  workQ에서 가장 앞에있는 시간까지는 어차피 아무것도 없으므로 time을 그 시간으로 지정한다 -> 쭉쭉 처리한다(두 힙이 모두 빌 때 까지)
        */
        PriorityQueue<int[]> workQ = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]); //전체 작업을 넣는 workQ는 요청을 한 시간 기준으로 힙 생성
        PriorityQueue<int[]> readyQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); //시점에 따라 가능한 작업을 넣는 큐
        
        for(int[] i : jobs) workQ.offer(i); // workQ먼저 채워준다.
        int answer = 0;
        int time = 0; //현재시간 기록
        
        while(!workQ.isEmpty()||!readyQ.isEmpty()){ //둘 다 빌때까지 반복
            while(!workQ.isEmpty() && time >= workQ.peek()[0]){ //현재 시간 기준 가능한 작업을 넣기위해            
                readyQ.offer(workQ.poll());
            }
            if(readyQ.isEmpty()){ //만약 지금 가능한 작업이 없다면, time 조정
                time = workQ.peek()[0];
            }
            /*
            가능한 작업이 있다면, 그 중 소요시간이 가장 짧은것부터 처리한다
            */
            else{
                System.out.println("원래? "+time);
                time += readyQ.peek()[1];
                System.out.println("현재 "+time);
                answer += time - readyQ.poll()[0];
                System.out.println("그래서 answer: "+answer);
            }
        }
        return answer/jobs.length;
    }
}