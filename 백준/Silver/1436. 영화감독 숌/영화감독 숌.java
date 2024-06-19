import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 666이 들어간 수 중 N번째로 작은 수를 구하면 된다.
     * 그냥 0부터 ++ 하면서 666이 들어가면 count 하면 되지 않을까?
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0 ;
        int startnumber = 666;

        while (true) {
            if (String.valueOf(startnumber).contains("666")) {
                count++;
            }
            if (count == N) {
                break;
            }
            startnumber++;
        }
        System.out.println(startnumber);
    }


}
