import java.util.*;

class Solution {
    private boolean[] visited;
    private List<String> result;
    private boolean found = false; // 정답을 찾았는지 체크하는 변수

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        result = new ArrayList<>();

        // **출발 공항 -> 도착 공항 기준 정렬**
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]); // 같은 출발지면 도착 공항 기준 정렬
            }
            return a[0].compareTo(b[0]); // 출발 공항 기준 정렬
        });

        dfs("ICN", tickets, 0, new ArrayList<>());

        return result.toArray(new String[0]);
    }

    private boolean dfs(String current, String[][] tickets, int usedCount, List<String> path) {
        path.add(current);

        if (usedCount == tickets.length) { // 모든 티켓을 사용했다면
            result = new ArrayList<>(path);
            return true; // 경로 완성
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) { // 출발 공항이 현재 공항과 일치할 때
                visited[i] = true;
                if (dfs(tickets[i][1], tickets, usedCount + 1, path)) {
                    return true; // 정답을 찾았으면 더 이상 백트래킹하지 않고 종료
                }
                visited[i] = false; // 백트래킹 (다른 경로 탐색 가능하도록)
            }
        }

        path.remove(path.size() - 1); // 되돌아가기 (경로 복구)
        return false;
    }
}
