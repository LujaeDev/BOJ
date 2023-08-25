import java.io.*;
import java.util.*;

public class BOJ11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N], ret = new int[N];
        ArrayDeque<Pair> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; ++i) {
            if(!dq.isEmpty() && dq.peekFirst().first() <= i - L)
                dq.removeFirst();

            while (!dq.isEmpty() && dq.peekLast().second() >= arr[i])
                dq.removeLast();

            dq.addLast(new Pair(i, arr[i]));
            ret[i] = dq.peekFirst().second();
        }

        for (int i = 0; i < N; ++i) {
            bw.write(ret[i] + " ");
        }

        br.close();
        bw.close();

    }

    static class Pair{
        private Integer y;
        private Integer x;
        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
        public Integer first() {
            return x;
        }
        public Integer second() {
            return y;
        }
    }
}
