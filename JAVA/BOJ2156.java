import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int []g = new int[n + 1];
        int []dp = new int[n + 1];

        for(int i = 1; i <= n; ++i) {
            g[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = g[1];

        if(n >= 2)
            dp[2] = g[1] + g[2];

        for(int i = 3; i <= n; ++i){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + g[i]);

            if(i >= 3)
                dp[i] = Math.max(dp[i], dp[i - 3] + g[i - 1] + g[i]);
        }

        System.out.print(dp[n]);
    }
}

