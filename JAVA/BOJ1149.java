import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ1149 {
    static int [][]cost;
    static int [][]cache;

    static public int sol(int idx, int beforeColor){
        if(idx >= cost.length)
            return 0;

        int ret = cache[idx][beforeColor];

        if(ret != 0)
            return ret;

        ret = 987654321;

        for(int i = 0; i < 3; ++i){
            if(i != beforeColor || idx == 0)
                ret = Math.min(ret, cost[idx][i] + sol(idx + 1, i));
        }

        return cache[idx][beforeColor] = ret;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        cost = new int[n][3];
        cache = new int[n][3];

        for(int i = 0; i < n; ++i){
            String arrayS[] = br.readLine().split(" ");

            for(int j = 0; j < 3; ++j)
                cost[i][j] = Integer.parseInt(arrayS[j]);
        }

        System.out.print(sol(0, 0));

        br.close();
    }
}