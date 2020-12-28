import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2565{
    public static int lis(int[] arr, int []dp){
        int ret = 1;

        dp[1] = 1;

        for(int i = 2; i <= 500; ++i){
            if(arr[i] == 0){
                continue;
            }

            dp[i] = 1;
            for(int j = 0; j < i; ++j){
                if(arr[i] > arr[j] && arr[j] != 0)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            ret = Math.max(ret, dp[i]);
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int []arr = new int[501];
        int []dpInc = new int[501];

        for(int i = 0; i < n; ++i){
            ArrayList<Integer> list = new ArrayList<Integer>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            while(st.hasMoreTokens()){
                list.add(Integer.parseInt(st.nextToken()));
            }

            arr[list.get(0)] = list.get(1);
        }

        System.out.print(n - lis(arr, dpInc));
    }
}
