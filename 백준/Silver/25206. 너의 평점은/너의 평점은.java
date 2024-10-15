import java.io.*;
import java.util.*;


public class Main {
    /* 학점 구하기
    전공평점 = (학점 * 과목평점)의 총합 / 학점의 총합
    F 는 0, P는 계산에서 제외
    오차가 10^-4 만큼이여야 하므로 출력도 대충 다섯째자리까지

    20줄동안 과목명 학점 평점 을 입력받고
    전공평점을 출력한다

    과목명은 필요없으니까 버리고 학점과 평점을 계산에 이용한다.
    각 평점에 맞는 점수는 Map에 세팅해놓고 필요할 때 꺼내쓴다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Double epsilon =1E-5;

        ArrayList<Double> grade = new ArrayList<>();
        ArrayList<Double> subjectRating = new ArrayList<>();

        HashMap<String, Double> rating = new HashMap<>();
        rating.put("A+", 4.5);
        rating.put("A0", 4.0);
        rating.put("B+", 3.5);
        rating.put("B0", 3.0);
        rating.put("C+", 2.5);
        rating.put("C0", 2.0);
        rating.put("D+", 1.5);
        rating.put("D0", 1.0);
        rating.put("F", 0.0);
        rating.put("P", -1.0);

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            grade.add(Double.parseDouble(st.nextToken()));
            Double tempRating = rating.get(st.nextToken());
            subjectRating.add(tempRating);
        }

        double ratingSum = 0.0;
        double gradeSum = 0.0;
        for (int i = 0; i < 20; i++) {
            int gradeInt = subjectRating.get(i).intValue();
            if (gradeInt != -1 ) {
                gradeSum += grade.get(i);
                ratingSum += grade.get(i) * subjectRating.get(i);
            }
        }

        bw.write(ratingSum / gradeSum + "\n");
        bw.flush();
    }
}
