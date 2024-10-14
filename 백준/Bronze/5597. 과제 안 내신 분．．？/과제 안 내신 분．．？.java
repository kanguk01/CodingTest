import java.io.*;
import java.util.*;


public class Main {
    /* 출석번호
    낸사람 주르륵 입력한다
    안낸사람을 작은 순서대로 출력하면 된다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        ArrayList<Integer> answer = new ArrayList<>();
        HashSet<Integer> attendance = new HashSet<>();

        for (int i = 0; i < 28; i++) {
            int attendanceStudent = Integer.parseInt(br.readLine());
            attendance.add(attendanceStudent);
        }

        for (int i = 1; i <= 30; i++) {
            if(!attendance.contains(i)) {
                answer.add(i);
            }
        }

        if (answer.get(0) < answer.get(1)) {
            bw.write(answer.get(0) + "\n" + answer.get(1));
        } else {
            bw.write(answer.get(1) + "\n" + answer.get(0));
        }
        bw.flush();
    }
}
