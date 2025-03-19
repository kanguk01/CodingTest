import java.util.*;

class Solution {
    /* 1:28
    1. 서비스 가입자를 최대한 늘리는 것
    2. 판매액을 최대한 늘리는 것
    
    n명의 사용자에게 이뫼콘 m개를 할인하여 판매
    이모티콘마다 할인율 다름 (10, 20, 30, 40)
    
    각 사용자는 자신의 기준 비율 이상 할인하는 이모티콘 모두 구매
    각 사용자는 자신의 기준 이모티콘 구매 비용의 합이 일정 가격 이상이 되면 이모티콘 구매 취소하고 서비스 가입
    
    n명의 구매 기준을 담은 users 배열 ([%, 가격], [%, 가격], ...])
    이모티콘 m개의 정가를 담은 emoticons 배열 [~,~,~,...]
    
    <출력>
    [이모티콘 플러스 서비스 가입 수, 이모티콘 매출 액]
    
    서비스 가입자 수가 많은게 1순위 -> 사용자가 마지노선으로 잡은 가격보다 넘어가야 한다
    
    전체탐색한다!
    */
    private int[] discounts = {10, 20, 30, 40}; // 할인율
    private int maxSubscribe = 0; // 최대 가입자 수
    private int maxPrice = 0; // 최대 매출
    
    public int[] solution(int[][] users, int[] emoticons) {
        int m = emoticons.length;
        int [] discountCase = new int[m]; // 각 이모티콘의 할인율 저장하는 배열
        
        // 모든 할인율 조합 탐색 (DFS)
        dfs(0, users, emoticons, discountCase);
        
        return new int[]{maxSubscribe, maxPrice};
    }
    
    private void dfs(int cur, int[][] users, int[] emoticons, int[] discountCase){
        if(cur == emoticons.length) { // 모든이모티콘 할인율을 결정하면
            check(users, emoticons, discountCase); // 할인율 조합에 대한 결과 구함
            return;
        }
        
        for(int discount : discounts) { // 각 할인율 적용하며 탐색
            discountCase[cur] = discount;
            dfs(cur + 1, users, emoticons, discountCase);
        }
    }
    
    private void check(int[][] users, int[] emoticons, int[] discountCase) {
        int subscribeCount = 0;
        int totalPrice = 0;
        
        for(int[] user : users){
            int minDiscount = user[0];
            int limitPrice = user[1];
            int userPrice = 0;
            
            for(int i=0; i<emoticons.length; i++) {
                if(discountCase[i] >= minDiscount) {
                    userPrice += emoticons[i] * (100 - discountCase[i]) / 100;
                }
            }
            
            if(userPrice >= limitPrice) {
                subscribeCount++;
            } else {
                totalPrice += userPrice;
            }
        }
        
        if(subscribeCount > maxSubscribe) {
            maxSubscribe = subscribeCount;
            maxPrice = totalPrice;
        } else if(subscribeCount == maxSubscribe) {
            maxPrice = Math.max(maxPrice, totalPrice);
        }
    }
    
}