import java.util.*;
/*
1. 모든 대문자 -> 소문자로
2. 소문자, 숫자, -, _, . 빼고 문자 제거
3. 마침표가 두개 연속이면 하나로
4. 마침표가 시작이나 끝에 있다면 제거
5. 빈 문자열이라면 a를 대입
6. 16자 이상이면 15자 이후 다 제거
7. 2자 이하라면 마지막 문자를 길이가 3이 될때까지 반복

11:54
*/

class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        answer = lower(answer);
        answer = removeEct(answer);
        answer = removeDot(answer);
        answer = removeFirstOrLastDot(answer);
        answer = emptyStringA(answer);
        answer = tooLong(answer);
        answer = tooShort(answer);
        
        return answer;
    }
    
    private String lower (String id) {
        return id.toLowerCase();
    }
    
    private String removeEct (String id) {
        StringBuilder result = new StringBuilder();
        for(int i=0; i<id.length(); i++){
            char tmp = id.charAt(i);
            if(tmp == '-' || tmp == '_' || tmp =='.' || tmp >= 'a' && tmp <= 'z' || tmp >= '0' && tmp <= '9')
                result.append(tmp);
            else {
                continue;
            }
        }
        return result.toString();
    }
    
    private String removeDot (String id) {
        int combo = 0; 
        StringBuilder result = new StringBuilder();
        for(int i=0; i<id.length(); i++) {
            if(id.charAt(i) == '.'){
                combo++;
            } else {
                if(combo >= 1) {
                    result.append('.');
                }
                combo = 0;
                result.append(id.charAt(i));
            }
        }
        return result.toString();
    }
    
    private String removeFirstOrLastDot (String id) {
        StringBuilder result = new StringBuilder();
        if(id.length() == 0) return "";
        if(id.charAt(0) == '.'){
            if(id.length() == 1) return "";
            for(int i = 1; i < id.length() - 1; i++){
                result.append(id.charAt(i));
            }
        } else {
            for(int i = 0; i < id.length() - 1; i++){
                result.append(id.charAt(i));
            }            
        }
        if(id.charAt(id.length() - 1) != '.'){
            result.append(id.charAt(id.length() - 1));
        }
        return result.toString();
    }
    
    private String emptyStringA(String id) {
        if(id.length() == 0) return "a";
        return id;
    }
    
    private String tooLong (String id) {
        StringBuilder result = new StringBuilder();
        
        if(id.length() >= 16) {
            for(int i=0; i<15; i++) {
                result.append(id.charAt(i));
            }
        } else {
            for(int i=0; i<id.length(); i++) {
                result.append(id.charAt(i));
            }
        }
        if(result.charAt(result.length() - 1) == '.') {
            result.deleteCharAt(result.length() - 1);
        }
            
        return result.toString();
    }
    
    private String tooShort (String id) {
        StringBuilder result = new StringBuilder();
        if(id.length() == 1) {
            for(int i=0; i<3; i++) {
                result.append(id.charAt(0));
            }
        } else if(id.length() == 2) {
            result.append(id.charAt(0));
            for(int i=0; i<2; i++) {
                result.append(id.charAt(1));
            }
        } else return id;
        return result.toString();
    }
}