import java.io.*;
import java.util.*;


public class Main {
    /* 스택 처리하는 문제
    첫 줄에 명령의 수 N이 주어진다.
    명령은 다음과 같다.
    1 X : 정수 X를 스택에 push 한다. (!<= X <= 100000)
    2 : 스택에 정수가 있다면 pop하고 출력한다. 없으면 -1을 출력한다.
    3 : 스택 크기를 출력한다.
    4 : 스택이 비어있으면 1, 없으면 0을 출력한다.
    5 : 스택에 정수가 있다면 peek하고 출력한다. 없으면 -1을 출력한다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> command = new Stack<>();
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int firstnumber = Integer.parseInt(st.nextToken());

            if (firstnumber == 1) {
                command.push(Integer.parseInt(st.nextToken()));
            } else if (firstnumber == 2) {
                if (command.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(command.pop());
                }
            } else if (firstnumber == 3) {
                System.out.println(command.size());
            } else if (firstnumber == 4) {
                if (command.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (firstnumber == 5) {
                if (command.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(command.peek());
                }
            }
        }
    }
}
