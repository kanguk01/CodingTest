import java.util.*;

class Solution {
    public int solution(String name) {
        /*
        위아래
        abcdefghijklm m까지 위로 12번 n까지는 13번
        nopqrstuvwxyz o까지 아래로 12번
        m까지는 해당 알파벳까지의 거리, n 이후로는 z에서 n 을 뺀 거리가 최소다.
        -> 위아래 조작은 결국 정해져있음
        
        양옆
        a가 있다면 그부분은 아에 지나치지 않아도 된다. 
        *a** 이면 정방향은 3번이지만 역방향은 두번만 하면 됨
        *aa** 라면 정방향으로가면 4번해야하지만 역방향은 두번만 하면 됨
        **a** 이런경우라면 정방향 역방향 모두 같음
        ***a* 마찬가지
        *a*a*
        
        따라서 처음 커서 바로옆에 a가 있다면 역방향이 좋다. 
        
        이런 경우는? ***aaaaaaa** 이런경우도 3번째까지 갔다가 돌아오는게 이득임
        -> 현재 지나온 커서보다 앞에 a가 연속으로 더 많다면, 다시 돌아오는게 이득이다.
        *****aaa* 근데 이런건 맨끝에 한번 들렸다가 다시 정방향으로 가는게 낫다
        어떻게 이걸 체계화를하지?
        */
        int answer = 0;
        int length = name.length();
        int minmove = length - 1; // 이게 최댓값임
        
        for(int i=0; i<length; i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i)+1 ); //상하이동은 이게 끝
        
            //좌우이동
            int nextIndex = i + 1;
            while (nextIndex < length && name.charAt(nextIndex) == 'A') { //다음에 A를 만나면 체크해야한다. 
                nextIndex++;
            }
            int move = 2 * i + length - nextIndex; //현재 위치에서 역방향으로 돌아가는 경우
            move = Math.min(move, 2 * (length - nextIndex) + i); //역방향으로 갔다가 정방향으로 다시 가는 경우와 비교
            minmove = Math.min(minmove, move);
        }
        answer += minmove;
        return answer;
    }
}