import java.io.*;
import java.util.*;


public class Main {
    /*
    창고 다각형

    다각형을 만들어야 한다. 가능한 다각형 중 가장 작은 창고를 만들어야 함

    <입력>
    첫 줄 : 기둥의 개수 N
    두번째부터 : 각 기둥의 왼쪽 면의 위치 L / 높이를 나타내는 정수 H (<=1000)

    <출력>
    창고 다각형의 면적 (최소)

    max 앞뒤로 계산해야할듯
    max 앞 -> 더 큰게 나올때마다 잘라서 계산
    max -> max 길이만큼의 넓이
        만약 max 값을 가진 Index가 여러개라면, 처음 max ~ 마지막 max 만큼
    max 뒤 -> 더 작은게 나올때마다 잘라서 계산

    20:50
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] box = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            box[i][0] = Integer.parseInt(st.nextToken());
            box[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(box, new Comparator<int[]>() { // 배열 오름차순 정렬
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0];
            }
        });

        int maxH = box[0][1];
        ArrayList<Integer> maxIndex = new ArrayList<>();

        for (int i = 0; i < N; i++) { // 최대 높이를 구한다.
            if (maxH < box[i][1]) { // 최대 높이를 가진 박스가 갱신될 경우
                maxIndex.clear();
                maxIndex.add(i);
            } else if(maxH == box[i][1]) { // 최대 높이가 같은게 등장할경우
                maxIndex.add(i);
            }
            maxH = Math.max(maxH, box[i][1]);
        }

        int maxIndexLeft = 0;
        int maxIndexRight = 0;
        int midBox = 0;

        // 최댓값이 여러개인 경우 크기 계산
        Collections.sort(maxIndex);
        maxIndexLeft = box[maxIndex.get(0)][0];
        maxIndexRight = box[maxIndex.get(maxIndex.size() - 1)][0] + 1;

        midBox = (maxIndexRight - maxIndexLeft) * maxH;

        int leftBox = 0;
        int tempMax = box[0][1]; // 왼쪽 시작 기둥 크기를 임시로 둔다
        int tempX = box[0][0]; // 왼쪽 시작 기둥 x 좌표를 임시로 둔다


        if (maxIndex.get(0) != 0) {
            for (int i = 1; i <= maxIndex.get(0); i++) {
                leftBox += tempMax * (box[i][0] - tempX); // (현재 기둥 - 이전 기둥 거리) * 현재 기둥 최대 높이

                if (box[i][1] > tempMax) { // 다음 기둥이 높다면 갱신함
                    tempMax = box[i][1];
                }

                tempX = box[i][0]; // 다음 기둥으로 시작 위치 갱신
            }
        }

        // 오른쪽 영역은 반대로
        int rightBox = 0;
        tempMax = box[N - 1][1];
        int currentRight = box[N - 1][0] + 1;

        for (int i = N - 2; i >= maxIndex.get(maxIndex.size() - 1); i--) {

            if (box[i][1] > tempMax) {
                rightBox += tempMax * (currentRight - (box[i][0] + 1));
                tempMax = box[i][1];
                currentRight = box[i][0] + 1;       // 현재 기둥의 오른쪽 끝 좌표로 갱신
            }
        }
        rightBox += tempMax * (currentRight - (box[maxIndex.get(maxIndex.size() - 1)][0] + 1));


        bw.write(leftBox + midBox + rightBox + "");

        bw.flush();
    }
}
