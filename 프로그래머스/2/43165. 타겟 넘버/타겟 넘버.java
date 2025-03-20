import java.util.*;

/* 
더하거나 빼서 타겟 숫자를 만들자 
12:40
*/


class Solution {
    private int count = 0;
    private int[] plusOrMinus = {1, -1};
    
    public int solution(int[] numbers, int target) {
        int[] numberCase = new int[numbers.length];
        
        dfs(0, numbers, target, numberCase);
        return count;
    }
    
    private void dfs (int cur, int[] numbers, int target, int[] numberCase) {
        if(cur == numbers.length) {
            check(numbers, target, numberCase);
            return;
        } else {
            for(int pom : plusOrMinus) {
                numberCase[cur] = numbers[cur] * pom;
                dfs(cur + 1, numbers, target, numberCase);
            }
        }
    }
    
    private void check (int[] numbers, int target, int[] numberCase) {
        int sum = 0;
        for (int number : numberCase) {
            sum += number;
        }
        
        if(sum == target) count++;
    }
}