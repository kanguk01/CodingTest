import java.util.*;

class Solution {
    public int solution(int[] people, int limit) { 
        /*
        정렬하고 limit/2 무게 전까지는 여러명이 탈 수 있다. 
        그 이후는 볼거없이 인당 배 1개임
        제일 가벼운 사람부터 배에 태우고 -> limit 넘으면 answer++ (limit/2의 무게까지만)
        */
        Arrays.sort(people);
        for(int i: people){
            System.out.print(i);            
        }
        int answer = 0;
        int weight = 0;
        int heavy = 0 ; //무거운사람이 어디부터 시작되는지
        int cur = 0;
        for(int i=0; i<people.length-1; i++){
            if(people[i]>limit/2) { //만약 limit의 절반보다 무게가 무겁다면 더이상 볼 필요가 없다.
                heavy = i;
                break;
            }
            weight += people[i]; //배에 태운다.
            if(weight + people[i+1]>limit){  //만약 다음사람 태웠을때 넘을 것 같으면
                answer++; //배 하나 더 주고
                weight = 0; //초기화
            }
        }
        return answer + people.length - heavy;
    }
}