/*
next = 10초 뒤로 이동
prev = 10초 전으로 이동 (00:00보다 작아진다면 00:00으로 고정)
만약 next, prev를 실행했는데 오프닝 구간이라면 -> 무조건 오프닝 끝 구간으로 점프

split(":") 으로 문자열을 자르고 계산한다. 
*/
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] now = pos.split(":");
        int h = Integer.parseInt(now[0]);
        int m = Integer.parseInt(now[1]);
        
        String[] opStart = op_start.split(":");
        int opStartH = Integer.parseInt(opStart[0]);
        int opStartM = Integer.parseInt(opStart[1]);
        
        String[] opEnd = op_end.split(":");
        int opEndH = Integer.parseInt(opEnd[0]);
        int opEndM = Integer.parseInt(opEnd[1]);
        
        if(isOpening(h,m, op_start, op_end)){
            System.out.println("바로 오프닝이다");
            h = opEndH;
            m = opEndM;
        }
        
        for(int i=0; i<commands.length; i++){
            if(commands[i].equals("next")){
                m += 10;
            } else if (commands[i].equals("prev")){
                m -= 10;
            }
            
            int[] afterformatting = {0,0};
            System.out.println("포매팅 들어가기 전: "+ h + "시 "+ m);
            afterformatting = timeformat(h,m, video_len);
            h = afterformatting[0];
            m = afterformatting[1];
            System.out.println("포매팅 들어간 후: "+ h + "시 "+ m);

            if(isOpening(h,m, op_start, op_end)){
                h = opEndH;
                m = opEndM;
            }
            System.out.println("지금시간은?: "+ h + "시 "+ m);
        }
        
        return answerformat(h,m);
    }
    
    // 현재 구간이 오프닝인지
    public boolean isOpening(int h, int m, String op_start, String op_end){
    
        String[] opStart = op_start.split(":");
        int opStartH = Integer.parseInt(opStart[0]);
        int opStartM = Integer.parseInt(opStart[1]);
        
        String[] opEnd = op_end.split(":");
        int opEndH = Integer.parseInt(opEnd[0]);
        int opEndM = Integer.parseInt(opEnd[1]);
        
        int opStartTime = 100 * opStartH + opStartM;
        int opEndTime = 100 * opEndH + opEndM;
        int nowTime = 100 * h + m;
        
        
        System.out.println("오프닝검사: 지금시간: "+nowTime + " 오프닝 시작시간: "+opStartTime + " 오프닝 끝나는시간 : "+opEndTime);
        if(nowTime>=opStartTime && nowTime<=opEndTime){
            System.out.println("오프닝이다!!" + nowTime);
            return true;
        }
        return false;
    }
    
    // 형식에맞게 변환
    public int[] timeformat(int h, int m, String video_len){
        String[] videoLen = video_len.split(":");
        int videoLenH = Integer.parseInt(videoLen[0]);
        int videoLenM = Integer.parseInt(videoLen[1]);
        
        int hformat = h;
        int mformat = m;
        if(m>=60){
            hformat += 1;
            mformat -= 60;
        } else if (m<0){
            hformat -= 1;
            mformat += 60;
        }
        
        if(hformat<0) {
            hformat = 0;
            mformat = 0;
        }
        
        if(hformat > videoLenH){
            hformat = videoLenH;
        }
        if(hformat == videoLenH){
            if(mformat > videoLenM){
                mformat = videoLenM;
            }
        }
        int[] timeformat = {hformat, mformat};
        return timeformat;
    } 
    
    // 정답 형식에 맞도록 변환
    public String answerformat(int h, int m){
        String answerH = Integer.toString(h);
        String answerM = Integer.toString(m);
        
        if(h<=9){
            answerH = "0" + Integer.toString(h);
        }
        if(m<=9){
            answerM = "0" + Integer.toString(m);
        }
        
        return answerH + ":" + answerM;
    }
        
}