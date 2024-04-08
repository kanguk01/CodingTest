import java.util.*;

class Solution {
    public int solution(int[] people, int limit) { 
        Arrays.sort(people);
        int answer = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            // 무게가 가장 가벼운 사람과 무거운 사람의 무게 합이 limit 이하인지 확인
            if (people[left] + people[right] <= limit) {
                left++; // 두 사람을 함께 태움
            }
            right--; // 무거운 사람은 무조건 태움
            answer++; // 구명보트 사용 횟수 증가
        }

        return answer;
    }
}
