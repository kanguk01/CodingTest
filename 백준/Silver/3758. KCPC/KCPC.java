import java.io.*;
import java.util.*;


public class Main {
    /*
    KCPC

    등수를 구해야함

    <입력>
    첫 줄 : 테스트 데이터 T 개
    두번째 줄 : 팀의 개수 n, 문제의 개수 k, 내 팀 ID t, 로그 엔트리의 개수 m
    이후 : m개의 줄 -> 각 풀이에 대한 정보가 제출 순서대로
        팀 ID i, 문제 번호 j, 획득한 점수 s

    21:45
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int tt = 0; tt < T; tt++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제의 개수
            int t = Integer.parseInt(st.nextToken()); // 내 팀 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리의 개수

            // 팀 배열 생성 (1번 팀부터 n번 팀까지)
            Team[] teams = new Team[n + 1];
            for (int i = 1; i <= n; i++) {
                teams[i] = new Team(i, k);
            }

            // 로그 순서대로 처리
            for (int time = 0; time < m; time++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problem = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                teams[teamId].submit(problem, score, time);
            }

            // 정렬 대상 리스트 생성
            List<Team> teamList = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                teamList.add(teams[i]);
            }

            // 정렬
            Collections.sort(teamList);

            // 내 팀의 순위 찾기
            for (int i = 0; i < teamList.size(); i++) {
                if (teamList.get(i).id == t) {
                    bw.write(i + 1 + "\n"); // 순위는 1부터 시작
                    break;
                }
            }
        }

        bw.flush();
    }

    static class Team implements Comparable<Team> {
        int id;
        int[] scores;       // 문제별 최고 점수
        int totalScore;     // 총점
        int submitCount;    // 제출 횟수
        int lastSubmitTime; // 마지막 제출 시점

        public Team(int id, int k) {
            this.id = id;
            this.scores = new int[k + 1]; // 문제 번호는 1부터 시작
        }

        public void submit(int problem, int score, int time) {
            if (score > scores[problem]) {
                totalScore += (score - scores[problem]);
                scores[problem] = score;
            }
            submitCount++;
            lastSubmitTime = time;
        }

        @Override
        public int compareTo(Team o) {
            // 1. 총점 높은 팀 우선
            if (this.totalScore != o.totalScore)
                return o.totalScore - this.totalScore;

            // 2. 제출 횟수 적은 팀 우선
            if (this.submitCount != o.submitCount)
                return this.submitCount - o.submitCount;

            // 3. 마지막 제출 시간이 빠른 팀 우선
            return this.lastSubmitTime - o.lastSubmitTime;
        }
    }
}