import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        /*
        진출 시점을 기준으로 쭉 정렬한다.
        카메라를 첫번째 차의 진출 시점에 설치한다.
        그리고 배열을 돌면서 진입 시점보다 더 크다면 해당 차의 진출 시점으로 갱신하고 카메라++
        그러면 어차피 이전카메라는 지날수밖에 없으므로 고려할 필요가 없어진다.
        */
        int answer = 0;
        Arrays.sort(routes, (a,b) -> {return a[1] - b[1];}); //정렬

        int max = routes[0][1]; //일단 처음 카메라는 첫 차의 진출시점에 설치
        answer ++;
        for(int[] route : routes){ //배열순회하면서
            if(max < route[0]) { //진출 시점보다 진입 시점이 크면
                max = route[1]; // 갱신하고
                answer++; //++
            }

        }

        return answer;
    }
}