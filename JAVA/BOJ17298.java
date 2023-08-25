import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1], ret = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Pair> s = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        s.push(new Pair(0, arr[0]));

        for (int i = 1; i < N; ++i) {
            while (!s.empty() && s.peek().second() < arr[i]) {
                Pair pop = s.pop();

                int index = pop.first();
                ret[index] = arr[i];
            }

            s.push(new Pair(i, arr[i]));
        }

        for(int i = 0; i < N; ++i){
            if (ret[i] == 0)
                ret[i] = -1;

            int value = ret[i];

            sb.append(value + " ");
        }

        bw.write(sb.toString());

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
