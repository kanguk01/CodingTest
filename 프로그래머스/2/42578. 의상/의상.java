import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> cloth = new HashMap<>(); //옷 종류와 개수를 저장할 해시맵 선언
        
        /*
        옷 종류가 해시에 없다면 새로운 값으로 추가
        이미 있다면 값을 1 증가
        이렇게 하면 해쉬에 옷 종류들이 key, 각 종류의 개수가 value로 저장되게 된다.
        
        예시
        headgear : 2 (a)
        eyewear : 1 (b)
        -> 5
        a+b+ab
        
        */
        for(int i=0; i<clothes.length; i++){
            if(!cloth.containsKey(clothes[i][1])){
                cloth.put(clothes[i][1], 1);
            }
            else{
                cloth.replace(clothes[i][1], cloth.get(clothes[i][1]) + 1);
            }
        }
        for(String k : cloth.keySet()){
            answer *= cloth.get(k)+1;
        }
        
        return answer-1;
    }
}