import java.io.*;
import java.util.*;


public class Main {
    /*
    비슷한 단어

    비슷한 단어를 찾는다

    <입력>
    첫 줄 : 단어 개수
    두번째 줄 이후 : 단어 쭈르륵

    <출력>
    첫 번째 단어와 비슷한 단어 개수

    13:30
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        String firstWord = st.nextToken();
        ArrayList<String> word = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < N - 1; i++) {
            word.add(br.readLine());
        }

        HashMap<Character, Integer> firstToken = new HashMap<>();

        for (int i = 0; i < N - 1; i++) {
            firstToken.clear(); // 첫번째 단어 해시맵에 세팅
            for (int k = 0; k < firstWord.length(); k++) {
                firstToken.put(firstWord.charAt(k), firstToken.getOrDefault(firstWord.charAt(k),0) + 1);
            }

            int one = 1;
            boolean simm = true;
            String curWord = word.get(i);

            for (int j = 0; j < curWord.length(); j++) { // 검사한다
                char curToken = curWord.charAt(j);
                if (!firstToken.containsKey(curToken) || firstToken.get(curToken) == 0) {
                    if (one == 1) {
                        one--;
                    } else {
                        simm = false;
                        break;
                    }
                } else {
                    if (firstToken.get(curToken) >= 2) {
                        int reduceValue = firstToken.get(curToken) - 1;
                        firstToken.put(curToken, reduceValue);
                    } else {
                        firstToken.remove(curToken);
                    }
                }
            }
            int sum = 0;
            for (int val : firstToken.values()) {
                sum += val;
            }
            if (simm && sum <= 1) {
                answer++;
            }
        }

        bw.write(answer + "");

        bw.flush();
    }
}