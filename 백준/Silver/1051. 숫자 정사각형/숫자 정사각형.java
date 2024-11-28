import java.io.*;
import java.util.*;


public class Main {
    /*
    꼭짓점에 쓰여 있는 수가 같은 정사각형 찾기
    일단 이차원 배열로 싹 다 넣고
    각 원소마다 정사각형이 있는지 싹 체크
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<String> inputNumbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            inputNumbers.add(br.readLine());
        }

        String[][] numbers = new String[N][M];

        for(int i = 0; i < N; i++) {
            numbers[i] = inputNumbers.get(i).split("");
        }

        int max = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                max = Math.max(max, isSquare(numbers, i, j, N, M));
            }
        }

        bw.write(max * max + "\n");
        bw.flush();
    }

    /*
    특정 인덱스를 대상으로 시작
    해당 수부터 오른쪽 아래로 쭉 탐색한다

    현재 인덱스 i, j
    사이즈는 N, M 중 먼저 끝나는 인덱스까지만 탐색
     */
    public static int isSquare(String[][] numbers, int i, int j, int N, int M) {
        int minLength = Math.min(N - i, M - j); // 현재 인덱스부터 끝까지 남은 인덱스 중 작은 애를 기준으로 그만큼 탐색
        String number = numbers[i][j];
        int maxLength = 0;

        for(int k = 0; k < minLength; k++) {
            if(number.equals(numbers[i + k][j])) {
                if(number.equals(numbers[i][j + k])) {
                    if(number.equals(numbers[i + k][j + k])) {
                        maxLength = Math.max(maxLength, k + 1);
                    }
                }
            }
        }
        return maxLength;
    }


}
