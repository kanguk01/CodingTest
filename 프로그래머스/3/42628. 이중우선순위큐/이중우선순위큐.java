import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        /*
        조건에 맞춰 오름차순 큐와 내림차순 큐를 왔다갔다 하면서 추가 삭제한다
        */
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        String order, num;
        for(String s : operations){
            order = s.split(" ")[0];
            num = s.split(" ")[1];
            
            if(order.equals("I")){ //I 면 삽입
                queue.offer(Integer.parseInt(num));
            }
            else{ //D면
                if(queue.size()<1) continue; //비어있으면 무시
                if(num.equals("1")){ //1이면 최댓값을 삭제해야하기때문에 내림차순 큐로 옮기고 거기서 삭제
                    PriorityQueue<Integer> reverseq = new PriorityQueue<>(Collections.reverseOrder());
                    while(!queue.isEmpty()){ //옮기고
                        reverseq.offer(queue.poll());
                    }
                    reverseq.poll(); //삭제하고
                    while(!reverseq.isEmpty()){ //다시옮기고
                        queue.offer(reverseq.poll());
                    }
                }
                else{
                    queue.poll();
                }
            }
        }
        int[] answer = new int[2];
        if(queue.size()==0) {
            return answer;
        }
        else{
            answer[1] = queue.poll();
            while(!queue.isEmpty()){
                answer[0] = queue.poll();
            }
        }

        return answer;
    }
}