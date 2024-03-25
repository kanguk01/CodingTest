import java.util.*;

class Solution {
    int[] cards;
    public int solution(String numbers) {
        /*
        주어진 숫자를 조합하여 만들어지는 모든 숫자를 다 만들고..
        i 가 소수인지 아닌지? -> i 의 제곱근까지 다 나눠봐서 나누어떨어지지 않으면 소수겠지? 
        7자리 숫자니까... 9999999까지의 숫자 싹 보면 되지않을까?
        뽑은 카드개수를 배열에 저장한다. 각 인덱스 값은 그 인덱스 숫자의 카드 개수
        그리고 1부터 9999999까지 완전탐색한다 (소수이면서 내가 뽑은 카드로 만들어지는 숫자면 answer++)
        */
        int answer = 0;
        cards = new int[10];
        for(int i=0; i<numbers.length(); i++){ //내가 뽑은 카드들 개수를 기록하는 배열
            cards[Character.getNumericValue(numbers.charAt(i))]++;
        }
        
        for(int i=2; i<10000000; i++){
            if(isPrime(i)&&makeNum(i)) {
                answer++;
            }
        }
        
        return answer;
    }
    public boolean makeNum(int n){
        int[] cardscopy = cards.clone();
        while(n>=1){
            if(cardscopy[n%10]==0){
                return false;
            }
            cardscopy[n%10]--;
            n/=10;
        }
        return true;
    }
    public boolean isPrime(int n){ //소수인가?
        boolean isP = true;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return isP;
    }
}