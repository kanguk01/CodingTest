import java.io.*;
import java.util.*;


public class Main {
    /*
    최소 거리 구한다
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int widthMin = Math.min(x, w-x);
        int heightMin = Math.min(y, h-y);
        int minDistance = Math.min(widthMin, heightMin);

        bw.write(minDistance + "\n");
        bw.flush();
    }
}
