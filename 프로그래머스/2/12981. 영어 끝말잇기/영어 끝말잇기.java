import java.util.ArrayList;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        ArrayList<String> tmp = new ArrayList<>();
        
        int tmpnum = 0;
        tmp.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            if(comp(words[i-1],words[i])){
                for(int j=0; j<tmp.size(); j++){
                        if((tmp.get(j)).equals(words[i])){
                            tmpnum = i;
                            break;
                        }
                }
                if(tmpnum==0){
                    tmp.add(words[i]);
                }
                else{break;}
            }
            else {
                tmpnum = i;
                break;
            }
        }
        
        if(tmpnum != 0){
            answer[0]= (tmpnum%n)+1;
            answer[1]= (tmpnum/n)+1;
        }

        return answer;
    }
    
    boolean comp(String a, String b){
        int as = a.length();
        if(a.charAt(as-1)==b.charAt(0))
            return true;
        else {return false;}
    }
}

