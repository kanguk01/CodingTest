import java.util.*;

class Solution {
    // Union-Find 구현을 위한 클래스, 최소 신장 트리를 위해 크루스칼 알고리즘 사용한다.
    class UnionFind {
        int[] parent; //정점의 부모 노드
        
        public UnionFind(int n) { // 초기에는 자기 자신이 루트 노드가 되도록 초기화
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) { // 해당 정점의 루트 노드를 찾는것(재귀적으로)
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
        
        public void union(int x, int y) { // Union 연산으로 인해 집합이 합쳐짐
            x = find(x);
            y = find(y);
            if (x != y) parent[y] = x; // 루트 노드가 다르다면, 두 집합은 서로 합쳐질 수 있다는 것이므로 합침
        }
    }
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[2] - b[2]); // 간선을 비용 오름차순으로 정렬
        
        UnionFind uf = new UnionFind(n);
        int answer = 0;
        int edgeCount = 0;
        
        for (int[] cost : costs) {
            int island1 = cost[0];
            int island2 = cost[1];
            int costValue = cost[2];
            
            if (uf.find(island1) != uf.find(island2)) { // 사이클이 형성되지 않는다면
                uf.union(island1, island2); // 두 섬을 연결하고
                answer += costValue; // 비용을 더함
                edgeCount++;
            }
            
            if (edgeCount == n - 1) break; // 모든 섬을 연결했다면 종료
        }
        
        return answer;
    }
}
