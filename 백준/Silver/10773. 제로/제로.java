import java.util.*;

public class Main {
    /**
     * 팩토리얼에서 0이 나오는 경우는 2 * 5로 인해 발생된다.
     * 그러면 5의 개수를 세는 것이 0의 개수를 세는 것이 된다.
     * ?? 그리고 5의 제곱, 세제곱과 같이 더 큰 수에서도 0이 나올 수 있다.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Stack<Integer> jangboo = new Stack<>();
        while(count>0){
            int number = scanner.nextInt();
            if(number == 0){
                jangboo.pop();
            } else {
                jangboo.push(number);
            }
            count--;
        }
        int sum = 0;
        while(!jangboo.isEmpty()){
            sum += jangboo.pop();
        }
        System.out.println(sum);

    }
}
