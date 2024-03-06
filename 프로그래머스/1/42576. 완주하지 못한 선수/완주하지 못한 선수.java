import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> parti = new HashMap<>();
        /*
        참여자 hashmap을 만든다
        없는값이였다면 1로 추가
        있다면 1씩 ++해준다.
        */
        for(int i=0; i<participant.length; i++){ 
            if(!parti.containsKey(participant[i])){
                parti.put(participant[i], 1);
            }
            else{
                parti.put(participant[i], parti.get(participant[i])+1);
            }
        }
        /*
        완주한 사람들을 참여자 hashmap에 비교한다
        하나만 있으면 해쉬에서 삭제, 여러개가 있었다면 -1하다가 마지막에 삭제
        */
        for(int i=0; i<completion.length; i++){
            if(parti.get(completion[i]) == 1){
                parti.remove(completion[i]);
            }
            else{
                parti.replace(completion[i], parti.get(completion[i])-1);
            }
        }
        /*
        hashmap에 남는값은 딱 하나일 것이다. keySet을 이용하여 출력
        */
        for(String a : parti.keySet()){
            answer = a;
        }
        return answer;
    }
}