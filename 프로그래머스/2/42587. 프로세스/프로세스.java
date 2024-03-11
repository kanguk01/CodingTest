import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        /*
        큐는 FIFO이다. 맨 앞에있는 것부터 꺼낸다.
        우선순위를 비교한다. 더 큰 숫자가 있으면 다시 큐에 넣는다.(그러면 맨 뒤로 밀린다.)
        원하는 location 프로그램의 실행 순서를 출력한다. 
        */
        Queue<int[]> proc = new LinkedList<>(); //큐 생성 data = {priorities[i], i}
        int[] index = new int[2];
        ArrayList<Integer> prior = new ArrayList<>(); // 우선순위만 저장
        for(int i=0; i<priorities.length; i++){
            index = new int[]{priorities[i], i};
            prior.add(priorities[i]);
            proc.offer(index);
        }
        Collections.sort(prior, Collections.reverseOrder()); //우선순위를 정렬하여 처음 원소에만 비교하면 되도록 한다.
        int answer = 0;
        /*
        poll한다 -> 우선순위를 비교해서 -> 큰게있으면 다시 offer한다. -> 제일크면 다시 poll한다 +  answer++ ->제일 클 때 poll()[1]이 location이라면 -> 그 때 answer 리턴한다.
        */
        while(!proc.isEmpty()){ 
            int tmpidx = proc.peek()[1];
            int tmppri = proc.poll()[0];
            if(tmppri >= prior.get(0)){ //우선순위가 제일 크다면
                answer++;
                if(tmpidx == location) return answer;
                prior.remove(0);
                continue;
            }
            index = new int[]{tmppri, tmpidx};
            proc.offer(index);
        }
        return answer;
    }
}