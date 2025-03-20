import java.util.*;
/*
문자열을 몇개로 잘라서 압축해야 최대한으로 압축되는지 문자열의 결과값 출력

s 길이 <= 1000 이하 -> 완전탐색 문제없음

s길이/2 만큼 완전탐색을 해서 판별한다

1:20
0,1 1,2 2,3 3,4
0,2 2,4 5


*/

class Solution {
    public int solution(String s) {
        if(s.length() == 1) return 1;
        ArrayList<String> split = new ArrayList<>();
        StringBuilder answer = new StringBuilder();
        int length = 1000;
        
        for(int i=1; i<=s.length()/2; i++) {
            for(int j=0; j<=s.length()-i; j+=i){
                split.add(s.substring(j, j+i));
            }
            if(s.length() % i != 0){ //마지막 남은 부분
                split.add(s.substring(s.length() - s.length() % i));
            }
            
            String prev = split.get(0);
            answer.append(prev); // 첫 단어는 어차피 일단 들어가야함
            
            boolean flag = false; // 연속해서 압축인지
            int seq = 1;
            
            for(int k=1; k<split.size(); k++) { // 앞에서부터 차례대로 비교
                String next = split.get(k);
                if(prev.equals(split.get(k))){ // 비교군이랑 다음거랑 같으면 압축된다.
                    if(flag) { // 연속된 압축이면 숫자도 들어갈 필요 없다 -> 그냥 패스
                        seq++; 
                        continue; 
                    } else {
                        seq++;
                        flag = true; // 연속될 경우를 위해 플래그 넣어놓음
                    }
                    prev = next; // 다음 비교군을 넣어줌
                } else { // 다르면
                    if(seq != 1){ // 연속되고있었다면 연속숫자 넣어줌
                        answer.append("" + seq);                        
                    }
                    seq = 1;
                    prev = next; // 다음 비교군 넣고
                    flag = false;
                    
                    answer.append(split.get(k)); // 정답에 그냥 문자열 그대로 넣음
                }           
            }
            if(seq != 1){ // 마지막 연속숫자 넣어줌
                answer.append("" + seq);                        
            }                 
            length = Math.min(length, answer.length()); // 더 작은거 적용
            // System.out.println(answer);
            answer.setLength(0);
            split.clear(); // 초기화해줌
        
        }
        return length;
    }
}