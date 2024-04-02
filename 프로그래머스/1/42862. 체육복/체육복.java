import java.util.*;

class Solution {
    /*
    전체 학생 수 n, 안가져온 학생 lost, 여벌있는 학생 reserve
    */
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n+1]; //일단 모든 학생의 배열을 만들자
        for(int i=0; i<=n; i++){
            student[i] = 1;
        }
        for(int i : reserve){ //여벌 있는 애는 1을 더해줌
            student[i] += 1;
        }
        for(int i : lost){ //체육복 도난당한애들은 1을 빼줌
            student[i] -= 1;
        }
        for(int i: student){
            System.out.print(i);
        }
        
        /*
        여벌이 있는학생 앞뒤로 0이있으면 일단 걔한테 준다(앞숫자 먼저 다음 뒤숫자)
        */
        for(int i=1; i<=n; i++){
            if(student[i]==2){ //체육복 두개인 애들 중
                if(student[i-1]==0){ //앞에가 없으면
                    student[i-1]=1; //앞에 주고
                    student[i]=1;
                }
                else if(i<student.length-1&&student[i+1]==0){ //뒤에가 없으면 
                    student[i+1]=1; //뒤에 준다
                    student[i]=1;
                }
            }
        }
        student[0]=0; //0은 빼고
        for(int i=1; i<=n; i++){
            if(student[i]!=0) answer++;
        }
        
        return answer;
    }
}