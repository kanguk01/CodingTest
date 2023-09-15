
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] st = new String[skill_trees.length];
        for(int i=0; i<st.length; i++){
            st[i]= skill_trees[i].replaceAll("[^" + skill + "]", "");
        
        }
        
        
        for(int j=0; j<st.length; j++){
            if(st[j].equals("")){answer++;}
            else
                for(int k=1; k<=skill.length(); k++){
                    if(skill.substring(0,k).equals(st[j])){answer++;}
                }
        }

        
        return answer;
    }
}