import java.io.*;
import java.util.*;


public class Main {
    /*
    add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
    remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
    check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
    toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
    all: S를 {1, 2, ..., 20} 으로 바꾼다.
    empty: S를 공집합으로 바꾼다.

    Set으로 처리하면 쉽지않을까?
    */

    static int current = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;

                case "remove":
                    int removeValue = Integer.parseInt(st.nextToken());
                    if(set.contains(removeValue)) {
                        set.remove(removeValue);
                    }
                    break;

                case "check":
                    if(set.contains(Integer.parseInt(st.nextToken()))) {
                        bw.write("1" + "\n");
                    } else {
                        bw.write("0" + "\n");
                    }
                    break;

                case "toggle":
                    int toggleValue = Integer.parseInt(st.nextToken());
                    if(set.contains(toggleValue)) {
                        set.remove(toggleValue);
                    } else {
                        set.add(toggleValue);
                    }
                    break;

                case "all":
                    for(int j = 1; j <= 20; j++){
                        set.add(j);
                    }
                    break;

                case "empty":
                    set.clear();
                    break;
            }
        }
        bw.flush();
    }
}
