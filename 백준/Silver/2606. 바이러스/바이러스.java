import java.io.*;
import java.util.*;


public class Main {
    /**
     * 바이러스
     * 그래프를 구현하고 DFS시키면 된다.
     * 첫째줄에는 컴퓨터의 수 = N
     * 두번째 줄에는 간선의 수 = M
     * 시작 노드 V = 1
     */

    static int N,M, count;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        M = Integer.parseInt(br.readLine());
        int V = 1;
        for (int i = 0; i <= N; i++) { // 그래프의 뼈대 생성
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) { // 그래프에 간선들 추가
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start); // 양방향 그래프일것으므로 둘다 추가시켜줌
        }

        for (int i = 0; i <= N; i++) {
            visited[i] = false;
        }

        dfs(V);
        System.out.println(count);

    }
    private static void dfs(int V) { 
        visited[V] = true;
        for (Integer i : graph.get(V)) {
            if (!visited[i]) {
                count++;
                dfs(i);

            }
        }
    }
}
