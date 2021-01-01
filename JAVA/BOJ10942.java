import java.io.*;
import java.util.StringTokenizer;

public class BOJ10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n + 1];
        boolean dp[][] = new boolean[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; ++i) {
            dp[i][i] = true;

            if(i < n && arr[i] == arr[i + 1])
                dp[i][i + 1] = true;
        }

        for(int mid = 2; mid < n; ++mid){
            int step = 1;

            while(mid - step >= 1 && mid + step <= n){
                int s = mid - step;
                int e = mid + step;

                if(dp[s + 1][e - 1] == false)
                    dp[s][e] = false;
                else{
                    if(arr[s] == arr[e])
                        dp[s][e] = true;
                    else
                        dp[s][e] = false;
                }

                step++;
            }
        }

        for(int mid2 = 2; mid2 < n; ++mid2){
            int step = 1;

            while(mid2 - step >= 1 && mid2 + 1 + step <= n){
                int s = mid2 - step;
                int e = mid2 + 1 + step;

                if(dp[s + 1][e - 1] == false)
                    dp[s][e] = false;
                else{
                    if(arr[s] == arr[e])
                        dp[s][e] = true;
                    else
                        dp[s][e] = false;
                }

                step++;
            }
        }

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; ++i){
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if(dp[S][E])
                bw.write("1\n");
            else
                bw.write("0\n");
        }

        bw.close();
    }
}
