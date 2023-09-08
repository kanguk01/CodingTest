class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int arrs = numbers.length;
        int inde = (((1+2*(k-1))%arrs));
        
        if(inde==0) return numbers[arrs-1];
        
        else {
            return numbers[inde-1];
        }
    }
}