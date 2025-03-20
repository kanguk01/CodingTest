import java.util.*;

/*
디딤돌 숫자는 한 번 밟을 때마다 1씩 줄어듬
0이되면 밟을 수 없고 그 다음 디딤돌로 뛸 수 있음 (제한 k)
그 중 가장 가까운 디딤돌로만 건넘

k만큼 뛸 수 있다. 최대 몇 명까지 건널 수 있는지

효율성도 챙겨야한다

이분 탐색을 통해 몇명이 건널수있나 탐색
stone의 최대 크기는 2억이니까, 1~2억까지 이분탐색을 돌린다. 


21:30
*/

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        int mid = (left + right) / 2;
        
        while(left <= right) {
            if(canCross(mid, stones, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        return right + 1;

    }
    
    public boolean canCross(int mid, int[] stones, int k) {
        int zeroLength = 0;
        for(int stone : stones) {
            if(stone - mid <= 0) {
                zeroLength++;
                if(zeroLength >= k) {
                    return false;
                }
            }
            else {
                zeroLength = 0;
            }
            
        }
        return true;
    }
}