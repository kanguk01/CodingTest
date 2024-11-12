import java.io.*;
import java.util.*;


public class Main {
    /*
    Y = 2명
    F = 3명
    O = 4명

    Set으로 처리 -> 중복 제거 후 인원 비교
    */

    static int current = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<String> Member = new HashSet<>();

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        for(int i = 0; i < N; i++) {
            Member.add(br.readLine());
        }

        int result = 0;

        switch(game) {
            case "Y":
                result = Member.size();
                break;

            case "F":
                result = Member.size()/2;
                break;

            case "O":
                result = Member.size()/3;
                break;
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
