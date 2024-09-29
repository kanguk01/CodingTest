import java.io.*;
import java.util.*;


public class Main {
    /* 영어 암기장을 만드는 문제
    입력받을 단어의 개수 N과 단어 길이 M이 주어진다.
    그 아래줄부터 단어를 입력한다.

    <조건>
    자주 나오는 단어일수록 앞에 배치한다.
    단어의 길이가 길수록 앞에 배치한다.
    알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다.

    길이가 M 이상인 단어만 외운다.

    시간복잡도 N^2이되면 안된다.

    일단 M조건에 맞는 단어를 다 넣고
    정렬을 하자
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> words = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String newWord = br.readLine();
            if (newWord.length() >= M) {
                words.put(newWord, words.getOrDefault(newWord, 0) + 1);
            }
        }

        String[] wordbook = words.keySet().toArray(new String[0]); // HashMap의 키를 배열로 변환하는 메소드

        Arrays.sort(wordbook, (a, b) -> {
            int countCompare = words.get(b) - words.get(a); // 빈도수
            if (countCompare != 0) {
                return countCompare;
            }
            int lengthCompare = (b.length() - a.length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return a.compareTo(b);
        });

        for (String s : wordbook) {
            bw.write(s + "\n");
        }
        bw.flush();
        
    }
}
