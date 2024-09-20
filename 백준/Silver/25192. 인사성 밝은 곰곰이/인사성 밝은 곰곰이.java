import java.io.*;
import java.util.*;


public class Main {
    /* 곰곰티콘이 사용된 횟수를 구하는 문제
    ENTER < 새로운 사람이 입장함
    새로운 사람이 입장한 후 최초 채팅은 모두 곰곰티콘 카운팅
    그 이후는 그냥 채팅이므로 카운트 X (개별적용)

    그냥 중복 확인해서 배열에 넣고 더해주자
    -> 배열에 넣으니까 시간복잡도가 N^2 이 되어서 시간초과가 난다.
    Set으로 하자
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> nickname = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String newface = br.readLine();
            if (newface.equals("ENTER")) {
                answer += nickname.size();
                nickname.clear();
                continue;
            }
            nickname.add(newface);
        }
        answer += nickname.size();
        System.out.println(answer);

    }
}
