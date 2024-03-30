import java.util.*;

class Solution {
    
    char[] words = {'A', 'E', 'I', 'O', 'U'};
    int max = 5;
        
    public int solution(String word) {
        int answer = 0;
        
        ArrayList<String> elements = new ArrayList<>();
        
        for(int i=0; i<words.length; i++){
            dfs(elements, String.valueOf(words[i]));
        }    
        
        for(int i=0; i<elements.size(); i++){ //답 나올때까지 냅다 ++ 한다
            if(elements.get(i).equals(word)){
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
    
    void dfs(List<String> elements, String str){ //dfs 이용하여 단어 생성
        if(str.length() > max) return; //단어의 길이가 최대 5가 될때까지
        
        if(!elements.contains(str)) elements.add(str); //그리고 단어를 저장
    
        for(int i=0; i<words.length; i++){ //A, AA, AAA ... 이런식으로 생기다가 5가되면 멈추고 AAAAI 이런식으로 간다
            dfs(elements, str+words[i]);
        }
    }
}