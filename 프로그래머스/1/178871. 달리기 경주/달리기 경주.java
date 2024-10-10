import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int callingSize = callings.length;
        int playerSize = players.length;
        HashMap<String, Integer> playerAndGrade = new HashMap<>();
        HashMap<Integer, String> gradeAndPlayer = new HashMap<>();
        
        for(int i = 0; i < players.length; i++){
            playerAndGrade.put(players[i], i+1);
            gradeAndPlayer.put(i+1, players[i]);
        }
        
        for(int i = 0; i < callingSize; i++){
            String call = callings[i];
            int grade = playerAndGrade.get(call);
            String front =  gradeAndPlayer.get(grade - 1);
            playerAndGrade.replace(call, grade-1);
            playerAndGrade.replace(front, grade);
            
            gradeAndPlayer.replace(grade, front);
            gradeAndPlayer.replace(grade-1, call);

        }
        
        String[] answer = new String[playerSize];
        for(int i = 0; i < playerSize; i++){
            String person = players[i];
            int grade = playerAndGrade.get(person);
            answer[grade-1] = person;
        }

        return answer;
    }
}