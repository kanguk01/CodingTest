import java.io.*;
import java.util.*;


public class Main {
    /**
     * 상수는 수를 거꾸로 인식함
     * 더 큰 수를 출력
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        int firstone = first / 100;
        int secondone = second / 100;
        int firsttwo = (first / 10) % 10;
        int secondtwo = (second / 10) % 10;
        int firstthree = first % 10;
        int secondthree = second % 10;

        if (firstthree > secondthree) {
            System.out.println(firstthree * 100 + firsttwo * 10 + firstone);
            return;
        } else if(firstthree < secondthree){
            System.out.println(secondthree * 100 + secondtwo * 10 + secondone);
            return;
        } else {
            if (firsttwo > secondtwo) {
                System.out.println(firstthree * 100 + firsttwo * 10 + firstone);
                return;
            } else if (firsttwo < secondtwo) {
                System.out.println(secondthree * 100 + secondtwo * 10 + secondone);
                return;
            } else {
                if (firstone > secondone) {
                    System.out.println(firstthree * 100 + firsttwo * 10 + firstone);
                    return;
                } else {
                    System.out.println(secondthree * 100 + secondtwo * 10 + secondone);
                    return;
                }
            }
        }

    }
}
