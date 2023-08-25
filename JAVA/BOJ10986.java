import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10986 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int[] s = new int[N + 1], cnt = new int [1001];
        long ret = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            s[i] = (s[i - 1] + arr[i]) % M;

            if(s[i] == 0)
                ret += 1;
            ret += cnt[s[i]];
            cnt[s[i]]++;
        }

        System.out.println(ret);
    }
}
