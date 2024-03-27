class Solution {
    int max = 0;

    public int solution(int k, int[][] dungeons) {
        /*
        순열 알고리즘 해서 최댓값 구하면 된다(DFS로 구현 가능)
        */
        boolean[] visited = new boolean[dungeons.length];
        DFS(k, dungeons,visited);
        return max;
    }
    public void DFS(int k, int[][] dungeons, boolean[] visited){ //DFS로 구현
        int count = 0;
        for(int i = 0; i<visited.length; i++) {
            if(visited[i]) {
                count++;
            }
        }
        if(count > max) {
            max = count; //최댓값 넘으면 갱신
        }


        for(int i = 0; i<dungeons.length; i++) { //약간 트리 구조 형식으로 재귀 돌아간다.
            if(!visited[i]) {
                if(dungeons[i][0] <= k) {
                    visited[i] = true;
                    k -= dungeons[i][1];
                    DFS(k, dungeons, visited); //만약 여기서 끝난다면, 전단계에서 다시 진행이 된다. 그래서 모든 경우의 순열을 구할 수 있다. 
                    
                    k += dungeons[i][1]; //계산 한 뒤에는 다시 되돌려야함
                    visited[i] = false;
                }
            }
        }
    }
}