import java.io.*;
import java.util.*;


public class Main {
    /**
     * 절댓값 힙
     * 힙을 구현하는데 절댓값 기준으로 우선순위가 정해진다. 근데 절댓값이 같으면 더 작은수를 빼면 된다.
     * 0 이외의 숫자는 그 숫자를 힙에 넣고, 0이면 절댓값이 가장 작은 수를 힙에서 빼고 출력하면 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> absHeap = new PriorityQueue<>(new Comparator<Integer>() { // 우선순위 큐로 힙 선언
            @Override
            public int compare(Integer o1, Integer o2) { // 인데 커스텀 Comparator로
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);
                if (abs1 == abs2) {
                    return o1 - o2;
                }
                return abs1 - abs2;
            }
        });
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (absHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(absHeap.poll());
                }
            } else {
                absHeap.add(x);
            }
        }
    }
}
