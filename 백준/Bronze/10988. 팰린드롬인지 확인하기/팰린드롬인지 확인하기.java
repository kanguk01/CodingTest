import java.io.*;
import java.util.*;


public class Main {
    /* 팰린드롬 수인지?
    StringBuilder로 새로 만들고
    reverse해서 비교한다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        StringBuilder reverse = new StringBuilder(word);
        reverse.reverse();

        if (word.equals(reverse.toString())) {
            bw.write("1");
        } else {
            bw.write("0");
        }
        bw.flush();
    }
}
