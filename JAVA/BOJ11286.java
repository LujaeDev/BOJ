import java.io.*;
import java.util.PriorityQueue;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        int x;

        for (int i = 0; i < N; ++i) {
            x = Integer.parseInt(br.readLine());

            if (x != 0) {
                int sign = 1;
                if(x > 0)
                    sign = 1;
                else
                    sign = -1;

                pq.add(new Pair(Math.abs(x), sign));
            }else{

                Pair pair = pq.poll();
                if(pair == null)
                    pair = new Pair(0, 0);
                sb.append((pair.first() * pair.second())+ "\n");
            }
        }

        System.out.println(sb.toString());
        br.close();
        bw.close();
    }

    static private class Pair implements Comparable {
        int v1, v2;

        public Pair(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public int first() {
            return v1;
        }

        public int second() {
            return v2;
        }

        @Override
        public int compareTo(Object o) {
            Pair b = (Pair) o;

            int num1 = this.first();
            int num2 = b.first();

            if(num1 == num2)
                return this.second() - b.second();
            return this.first() - b.first();
        }
    }
}
