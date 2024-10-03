/*
정렬을 하는데 문자열 기준으로 a+b 한걸 큰 것을 기준으로 한다.
예시: [6,10,2] -> a = 6 b = 10 이라면 610과 106을 비교 -> 610이 크므로 6,10 순서
a = 10, b = 2 면 102, 210 -> 210이 크므로 2, 10 
따라서 6, 2, 10 순서로 정렬 된다. 나머지도 같은 로직으로 정리
*/

import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        // 숫자 배열을 문자열 배열로 변환
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }

        // 문자열을 이어 붙였을 때 더 큰 순서로 정렬하기 위해 정렬 기준 재정의
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));

        // 00000000.. 이면 0이 나와야 함
        if (strArr[0].equals("0")) return "0";

        // StringBuilder로 이어붙여서 반환
        StringBuilder answer = new StringBuilder();
        for (String str : strArr) {
            answer.append(str);
        }

        return answer.toString();
    }
}
