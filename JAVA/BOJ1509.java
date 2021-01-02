import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1509 {
    static boolean[][] palin;
    static int cache[];

    static int sol(int idx, int n){
        if(idx == n)
            return 0;

        if(cache[idx] != -1)
            return cache[idx];

        cache[idx] = 987654321;

        for(int i = idx; i < n; ++i)
            if(palin[idx][i])
                cache[idx] = Math.min(cache[idx], sol(i + 1, n) + 1);

        return cache[idx];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int n = str.length();
        palin = new boolean [n][n];

        for(int i = 0; i < n; ++i) {
            palin[i][i] = true;

            if(i + 1 < n && str.charAt(i) == str.charAt(i + 1))
                palin[i][i + 1] = true;
        }

        for(int e = 2; e < n; ++e){
            for(int s = e - 2; s >= 0; --s){
                if(palin[s + 1][e - 1] && str.charAt(s) == str.charAt(e))
                    palin[s][e] = true;
            }
        }

        cache = new int[n];
        for(int i = 0 ; i < n; ++i)
            cache[i] = -1;

        System.out.print(sol(0, n));
    }
}
