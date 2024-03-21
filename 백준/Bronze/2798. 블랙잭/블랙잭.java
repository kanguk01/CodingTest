import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int num = sc.nextInt();
//        System.out.println("num = "+num);
        int[] card = new int[size];
        int[] cardsum = new int[size*size*size];
        for(int i=0; i<size; i++){
            card[i] = sc.nextInt();
        }
        Arrays.sort(card);
        int index = 0;
        for(int i=0; i<size; i++){
            for(int j=i+1; j<size; j++){
                for(int k=j+1; k<size; k++) {
                    cardsum[index] = card[i] + card[j] + card[k];
//                    System.out.println(cardsum[index]);
                    index++;
                }
            }
        }
        Arrays.sort(cardsum);
        int answer = cardsum[cardsum.length-1];
        for(int i =0; i< cardsum.length; i++){
            if(cardsum[i]>num){
                answer = cardsum[i-1];
                System.out.println(answer);
                return;
            }
        }
        System.out.println(answer);



    }
}
