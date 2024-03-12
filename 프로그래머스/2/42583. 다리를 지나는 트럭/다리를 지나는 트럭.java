import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        /*
        다리에는 최대 bridge_length 대 올라갈 수 있고, 완전히 오른 weight를 버틸 수 있음.
        트럭은 1초에 1 length 이동함
        큐에 다 넣고 조건에 맞게 하나씩 꺼내면 될 듯
        */
        Queue<Integer> truck = new LinkedList<>(); //대기 트럭 큐
        Queue<int[]> bridge = new LinkedList<>();  //다리를 건너는 트럭 큐
        int briweight = 0;
        int time = 0;
        
        for(int i : truck_weights){ //대기 트럭 큐 
            truck.offer(i);
        }

        /*
        현재 다리 위 무게가 임계치보다 작거나 같고, length보다 작거나 같을때, 대기 트럭 큐에서 poll, 다리를 건너는 트럭 큐에 offer한다. , time++
        다리를 건너는 트럭 큐는 {무게, 들어간 시간} 형식으로 offer한다.
        offer한 시간을 같이 저장하고, 현재시간-그때시간 > brigde_length 일 때 poll한다.
        */
        
        while(!truck.isEmpty()){
            time++;
            if(!bridge.isEmpty()&& time - bridge.peek()[1] >= bridge_length){ //트럭이 다 건넜으면 제거
                briweight -= bridge.poll()[0];
                System.out.println("현재"+ time + "초에 poll됐음 무게는" + briweight);
            }
            
            if(!truck.isEmpty()&& briweight+truck.peek() <= weight && bridge.size()<=bridge_length){
                int pollweight = truck.poll();
                int[] info = new int[]{pollweight,time};
                System.out.println("트럭에서 poll돼서 맨 앞에있는건 "+ truck.peek());
                bridge.offer(info); 
                briweight += pollweight;
                System.out.println(pollweight + "추가해서 현재무게" + briweight +", "+ time + "초 지남");
            }


        }
        /*
        대기 트럭이 모두 올라왔다면, 현재 시간 + length 더하면 끝
        */
        System.out.println("대기트럭이 텅 빔" + truck.isEmpty()+"현재시간: "+ time);
        return time + bridge_length;
    }
}