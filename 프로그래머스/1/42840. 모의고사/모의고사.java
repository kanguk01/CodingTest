import java.util.*;
import java.util.ArrayList;

class Solution {
    /*
    각 각 수포자들이 찍는 유형을 다 선언해놓고, 정답을 맞춘 개수를 저장하는 배열을 만들어서 
    다 돌면서 정답이면 ++ 시킨다. 
    
    */
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
        /*
        일단 정답에 넣고 더 적으면 빼고 새로운 애를 넣고, 아니면 넣는다. 그러면 많이 맞춘 애들만 남는다.
        */
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