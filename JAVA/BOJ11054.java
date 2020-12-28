import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int []dpInc = new int[n + 1];
        int []dpDec = new int[n + 1];

        ArrayList<Integer> list = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        list.add(0);
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        dpInc[1] = 1;
        for(int i = 2; i < n; ++i){
            dpInc[i] = 1;

            for(int j = 1; j < i; j++) {
                if(list.get(i) > list.get(j))
                    dpInc[i] = Math.max(dpInc[i], dpInc[j] + 1);
            }
        }

        dpDec[n] = 1;
        for(int i = n - 1; i >= 1; --i){
            dpDec[i] = 1;

            for(int j = i + 1; j <= n; ++j) {
                if(list.get(i) > list.get(j))
                    dpDec[i] = Math.max(dpDec[i], dpDec[j] + 1);
            }
        }

        int ret = 0;
        for(int i = 1; i <= n; ++i){
            ret = Math.max(ret, dpInc[i] + dpDec[i] - 1);
        }

        System.out.print(ret);
    }
}
