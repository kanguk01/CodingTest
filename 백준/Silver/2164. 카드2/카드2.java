import java.io.*;
import java.util.*;


public class Main {
    /*
    카드를 하나 버리고 -> 그 다음 카드는 맨 아래로 옮기고
    를 반복한다

   한 장 남을 때 까지

    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Queue<Integer> card = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            card.offer(i);
        }

        while(card.size() > 1) {
            card.poll();
            if(card.size() == 1) {
                break;
            }
            int next = card.poll();
            card.offer(next);
        }

        bw.write(card.poll() + "\n");
        bw.flush();
    }
}
