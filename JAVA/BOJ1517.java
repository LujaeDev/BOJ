import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1517 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; ++i) {
            arr[i] = new Pair(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(arr);
        int ret = 0;

        for (int i = N - 1; i >= 0; i--) {
            int leftShift = N - 1 - i;
            int rightShift = i - (arr[i].second() - leftShift);

            ret += leftShift + rightShift;
        }

        System.out.println(ret / 2);
    }

    static class Pair implements Comparable{
        private int v1;
        private int v2;

        Pair(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public int first() {
            return this.v1;
        }

        public int second() {
            return this.v2;
        }


        @Override
        public int compareTo(Object o) {
            Pair tmp = (Pair) o;

            return this.v1 - tmp.v1;
        }
    }
}
