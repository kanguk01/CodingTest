import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        int answer = 1;
        int index = 0;
        for(int i=word.length()-1; i>=0; i--){
            if(word.charAt(index) != word.charAt(i)){
                answer = 0;
            }
            index++;
        }
        System.out.println(answer);
    }
}
