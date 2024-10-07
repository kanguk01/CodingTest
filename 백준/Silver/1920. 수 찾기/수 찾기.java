import java.io.*;
import java.util.*;


public class Main {
    /* 배열 A에 X라는 정수가 존재하는지?
    첫째 줄에 N (1~100,000)
    둘째 줄에 숫자 주르륵 (배열 A)
    셋째 줄에 M
    넷째 줄에 숫자 주르륵
    넷째 줄에 있는 숫자들이 배열 A에 있는지
    있으면 1, 없으면 0

    시간 제한이 중요한 문제같다
    Set을 활용하면 시간 제한에 걸리지 않을 것이다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> numbers = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int newNumber = Integer.parseInt(st.nextToken());
            if (numbers.contains(newNumber)) {
                bw.write("1" + "\n");
            } else {
                bw.write("0" + "\n");
            }
        }
        bw.flush();
    }
}
