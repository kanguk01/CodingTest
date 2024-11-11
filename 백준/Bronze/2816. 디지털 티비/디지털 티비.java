import java.io.*;
import java.util.*;


public class Main {
    /*
    각 순서에 맞게 배열에 넣고
    KBS1 먼저 끌어올리고
    KBS2 끌어올린다.
    */

    static int current = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        String[] channel = new String[N];

        for(int i = 0; i < N; i++) {
            channel[i] = br.readLine();
        }

        int KBS1Index = 0;

        for(int i = 0; i < N; i++) {
            if(channel[i].equals("KBS1")) {
                KBS1Index = i;
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < KBS1Index; i++) { // KBS1 까지 화살표 내림
            result.append("1");
            current++;
        }

        for (int i = 0; i < KBS1Index; i++) { // KBS1 첫번째로 끌어올림
            result.append("4");
            channel = four(channel, current);
        }

        int KBS2Index = 0;

        for(int i = 0; i < N; i++) {
            if(channel[i].equals("KBS2")) {
                KBS2Index = i;
            }
        }

        for (int i = 0; i < KBS2Index; i++) { // KBS2 까지 화살표 내림
            result.append("1");
            current++;
        }

        for (int i = 0; i < KBS2Index - 1; i++) { // KBS2 두번째로 끌어올림
            result.append("4");
            channel = four(channel, current);
        }

        bw.write(result.toString());
        bw.flush();
    }

    static String[] three(String[] channel, int i) {
        String tempPrevious = channel[i];
        String tempNext = channel[i + 1];

        channel[i] = tempNext;
        channel[i + 1] = tempPrevious;
        current++;

        return channel;
    }

    static String[] four(String[] channel, int i) {
        String tempPrevious = channel[i - 1];
        String tempNext = channel[i];

        channel[i - 1] = tempNext;
        channel[i] = tempPrevious;
        current--;

        return channel;
    }
}
