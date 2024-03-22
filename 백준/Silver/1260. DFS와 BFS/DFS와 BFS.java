import java.util.*;

public class Main {
    static int N ,M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //그래프
    static boolean[] visited ;
    public static void main(String[] args) {
        /*
        * 첫째 줄에 정점의개수N , 간선의 개수 M, 시작 노드 V
        * 둘째줄부터 연결된 노드 관계 표시
        * */
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N+1];
        M = sc.nextInt();
        int V = sc.nextInt();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){ //그래프 생성
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i=0; i<=N; i++){
            Collections.sort(graph.get(i));
        }
        for(int i=0; i<N+1; i++){
            visited[i] = false;
        }
        dfs(V);
        System.out.println();
        //여기까지 DFS

        for(int i=0; i<N+1; i++){ //다시 초기화
            visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;
        int now = 0;

        while(!queue.isEmpty()){ //BFS
            now = queue.poll();
            System.out.print(now + " ");
            for(Integer i : graph.get(now)){
                if(!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void dfs(int V){
        System.out.print(V+ " ");
        visited[V] = true;
        for(Integer i : graph.get(V)){
            if(!visited[i]){
                dfs(i);
            }

        }
    }
}
