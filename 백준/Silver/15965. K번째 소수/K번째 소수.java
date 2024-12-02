import java.io.*;
import java.util.*;


public class Main {
    /*
    k 번째 소수를 찾는다.
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(br.readLine());
        int[] prime = new int[600000];
        boolean[] numbers = new boolean[8000000];
        Arrays.fill(numbers, true);

        numbers[0] = false;
        numbers[1] = false;

        for (int i = 2; i < Math.sqrt(8000000); i++) {
            if(numbers[i]){
                for (int j = i * i; j < 8000000; j += i) {
                    numbers[j] = false;
                }
            }
        }

        int j = 0;
        for (int i = 0; i < 8000000; i++) {
            if(numbers[i]){
                prime[j] = i;
                j++;
            }
        }

        bw.write(prime[k - 1] + "\n");
        bw.flush();
    }
}
