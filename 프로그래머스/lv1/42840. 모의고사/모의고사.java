import java.util.*;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
        int[] cor = {0,0,0};
        
        if(supo1[0]==answers[0]){cor[0]++;}
        if(supo2[0]==answers[0]){cor[1]++;}
        if(supo3[0]==answers[0]){cor[2]++;}
        
        for(int i=1; i<answers.length; i++){
            if(supo1[i%5]==answers[i]){cor[0]++;}
            if(supo2[i%8]==answers[i]){cor[1]++;}
            if(supo3[i%10]==answers[i]){cor[2]++;}
        }
        
        ArrayList<Integer> grade = new ArrayList<>();
        grade.add(1);
        int maxg=cor[0];
        for(int i=1; i<3; i++){
            if(maxg<cor[i]){
                maxg=cor[i];
                for(int j=0; j<grade.size(); j++){
                    grade.remove(j);
                    grade.add(i+1);
                    }
                }
            else if(maxg==cor[i]){
                grade.add(i+1);
            }
        }
        int[] answer = new int[grade.size()];
        for(int i=0; i<answer.length; i++){
            answer[i]=grade.get(i);
        }
        
        return answer;
    }
}