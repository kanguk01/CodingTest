import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        int[] answer = new int[size];
        /*
        array 를 command[n][0]부터 command[n][1] 값까지 자른다
        그걸 정렬하고, command[n][2] 번째 인덱스의 값을 꺼내고,
        answer[n] = 그 값
        */
        for(int i=0; i<size; i++){
            /*
            내가 원하는것 : start : 2, end : 5라면, index 1부터 4까지 자르는걸 원함(i,j에서 1뺀값을 원함)
            */
            int start = commands[i][0]-1;
            int end = commands[i][1];
            /*
            예시 배열 : {1,2,3,4,5,6}
            copyOfRange(배열,2,5) = 인덱스 2부터 4까지 자르기 = {3,4,5}
            */
            int[] subarray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(subarray);
            //k=3 이면 3번째 숫자를 원하는것(실제 index = 2
            answer[i] = subarray[commands[i][2]-1];
        }
        return answer;
    }
}