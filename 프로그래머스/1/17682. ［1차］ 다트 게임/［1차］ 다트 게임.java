class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String[] splitarr = dartResult.split("");
        int[] score = new int[3];
        int tmp = 0;
        for(int i=0; i<splitarr.length; i++){ //점수만 추출한 배열 score[3]
            if(splitarr[i].equals("S")){
                int scorenum = Integer.parseInt(splitarr[i-1]);
                if(scorenum == 0 && i>=2 && isDigit(splitarr[i-2])){
                    if(Integer.parseInt(splitarr[i-2])==1){
                        score[tmp] = 10;
                        tmp++;
                    }
                    else{
                        score[tmp] = 0;
                        tmp++;
                    }
                }
                else{
                    score[tmp] = scorenum;
                    tmp++;
                }
            }
            else if(splitarr[i].equals("D")){
                int scorenum = Integer.parseInt(splitarr[i-1]);
                if(scorenum == 0 && i>=2 && isDigit(splitarr[i-2])){
                    if(Integer.parseInt(splitarr[i-2])==1){
                        score[tmp] = 100;
                        tmp++;
                    }
                    else{
                        score[tmp] = 0;
                        tmp++;
                    }
                }
                else{
                    score[tmp] = scorenum * scorenum;
                    tmp++;
                }
            }
            else if(splitarr[i].equals("T")){
                int scorenum = Integer.parseInt(splitarr[i-1]);
                if(scorenum == 0 && i>=2 && isDigit(splitarr[i-2])){
                    if(Integer.parseInt(splitarr[i-2])==1){
                        score[tmp] = 1000;
                        tmp++;
                    }
                    else{
                        score[tmp] = 0;
                        tmp++;
                    }
                }
                else{
                    score[tmp] = scorenum * scorenum * scorenum;
                    tmp++;
                }
            }
        }
        
        for(int i=0; i<splitarr.length; i++){
            if(splitarr[i].equals("*")){
                int idx = i/3;
                if(idx == 0 ){
                    score[0] *= 2;
                }
                else{
                    score[idx] *=2;
                    score[idx-1] *=2; 
                    System.out.println(score[idx]);
                }
            }
            else if(splitarr[i].equals("#")){
                int idx = i/3;
                
                score[idx] *=-1;
                
            }
        }
        answer = score[0] + score[1] + score[2];
        return answer;
    }
    
    public static boolean isDigit(String str){
        try{
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException ex){
            return false;
        }
    }

}