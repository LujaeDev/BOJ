import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class BOJ1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ret = 0;
        Pair[] arr = new Pair[N + 1];
        arr[0] = new Pair(-1, 0);

        for (int i = 1; i <= N; ++i) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = new Pair(num, i);
        }

        Arrays.sort(arr);

        for (int i = 1; i <= N; ++i) {
            int beforeIndex = arr[i].second();
            int diff = beforeIndex - i;
            ret = Math.max(ret, diff + 1);
        }

        System.out.println(ret);
        br.close();
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
