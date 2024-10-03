/*
i번째 숫자부터 j번째 숫자까지 자르고 정렬한 후 k번째에 있는 수 구하기
*/

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        int[] answer = new int[size];

        for(int i=0; i<size; i++){

            int start = commands[i][0]-1;
            int end = commands[i][1];
            /*
            예시 배열 : {1,2,3,4,5,6}
            copyOfRange(배열,2,5) = 인덱스 2부터 4까지 자르기 = {3,4,5}
            */
            int[] subarray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(subarray);
            answer[i] = subarray[commands[i][2]-1];
        }
        return answer;
    }
}