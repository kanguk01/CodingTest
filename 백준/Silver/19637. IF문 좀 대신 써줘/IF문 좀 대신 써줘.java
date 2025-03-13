import java.io.*;
import java.util.*;


public class Main {
    /*
    if문 좀 대신 써줘

    전투력에 맞는 칭호를 출력

    <입력>
    첫 줄 -> 칭호의 개수 N / 칭호를 출력해야 하는 캐릭터들의 개수 M (100,000 이하)

    두 번째 줄부터 -> 칭호의 이름 (String) / 해당 칭호의 전투력 상한값

    N + 2 번째 줄부터 -> 캐릭터의 전투력

    <출력>
    N + 2 번째 줄부터 출력된 캐릭터 칭호를 출력
    (만약 여러 경우가 가능한 경우엔 먼저 입력한게 출력)

    N^2 이 되면 안된다.
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Title> titleList = new ArrayList<>();

        for (int i = 0; i < N; i++) { // 칭호 리스트 만들기
            st = new StringTokenizer(br.readLine());

            titleList.add(new Title(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());
            int left = 0;
            int right = N - 1;
            int result = 0;


            while (left <= right) {
                int mid = (left + right) / 2;

                if (titleList.get(mid).maxPower >= power) {
                    right = mid - 1;
                    result = mid;
                } else {
                    left = mid + 1;
                }

            }
            bw.write(titleList.get(result).name + "\n");
        }

        bw.flush();
    }
}

class Title {
    String name;
    int maxPower;

    public Title(String name, int maxPower) {
        this.name = name;
        this.maxPower = maxPower;
    }
}
