import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10844 {
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][] dp = new int[101][10];
        int ret = 0;
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i < 10; ++i)
            dp[1][i] = 1;

        for(int i = 2; i <= n; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (j + 1 <= 9)
                    dp[i][j] += dp[i - 1][j + 1];
                if (j - 1 >= 0)
                    dp[i][j] += dp[i - 1][j - 1];

                dp[i][j] %= MOD;
            }
        }

        for(int i = 0; i < 10; ++i){
            ret += dp[n][i];
            ret %= MOD;
        }

        System.out.print(ret);
    }
}
