class Solution {
    public int[] solution(int brown, int yellow) {
        /*
        테두리 한 줄만 브라운, 나머지는 옐로우
        3부터 시작해서 총 원소 개수의 절반까지 돌면서 곱해지나 보고
        그 경우마다 색깔의 개수와 일치하는지 확인
        */
        int[] answer = new int[2];
        int carpet = brown+yellow;
        for(int i=3; i<=carpet/2; i++){
            if(carpet%i==0){
                int div = carpet/i;
                if((i-2)*(div-2) == yellow){
                    answer[0]=div;
                    answer[1]=i;
                    break;
                }
            }
        }

        return answer;
    }
}