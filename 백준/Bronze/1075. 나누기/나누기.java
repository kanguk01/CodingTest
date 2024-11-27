import java.io.*;
import java.util.*;


public class Main {
    /*
    그냥 하나씩 올리면서 나누어떨어지면 출력
    */

    static int current = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        int dirtyNumber = N % 100;
        int cleanNumber = N - dirtyNumber;

        int tempNumber = 0;
        while((cleanNumber + tempNumber) % F != 0){
            tempNumber++;
        }

        if(tempNumber < 10){
            bw.write("0" + tempNumber);
        } else {
            bw.write(tempNumber + "");
        }

        bw.flush();
    }
}
