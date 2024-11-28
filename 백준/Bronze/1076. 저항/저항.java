import java.io.*;
import java.util.*;


public class Main {
    /*
    ( 처음 색깔 값 , 두번째 색깔 값 ) * 마지막 색깔 곱
    자료형 주의
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        HashMap<String, long[]> resist = new HashMap<>();

        resist.put("black", new long[]{0,1});
        resist.put("brown", new long[]{1,10});
        resist.put("red", new long[]{2,100});
        resist.put("orange", new long[]{3,1000});
        resist.put("yellow", new long[]{4,10000});
        resist.put("green", new long[]{5,100000});
        resist.put("blue", new long[]{6,1000000});
        resist.put("violet", new long[]{7,10000000});
        resist.put("grey", new long[]{8,100000000});
        resist.put("white", new long[]{9,1000000000});

        long result = (resist.get(first)[0] * 10 + resist.get(second)[0]) * resist.get(third)[1];

        bw.write(result + "\n");
        bw.flush();
    }
}
