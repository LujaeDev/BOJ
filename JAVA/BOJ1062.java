import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1062 {
    static int combination(int before, int cnt, int K, int selected, int[] bitStr){
        if(cnt == K - 5){
            int can = 0;

            for(int i = 0; i < bitStr.length; ++i){
                if((selected & bitStr[i]) == bitStr[i]){
                    can++;
                }
            }

            return can;
        }

        int ret = 0;

        for(int i = before + 1; i < 26; ++i){
            if((selected & (1 << i)) == 0){
                ret = Math.max(ret, combination(i,cnt + 1, K, selected | (1 << i), bitStr));
            }
        }

        return ret;
    }

    static int sol(int N, int K, String[] arrStr){
        int bitArr[] = new int[N];

        String basicS = "antatica";
        int basicSelected = 0;

        for(int i = 0; i < basicS.length(); ++i){
            basicSelected |= 1 << (basicS.charAt(i) - 'a');
        }

        for(int i = 0; i < N; ++i){
            for(int j = 0; j < arrStr[i].length(); ++j){
                bitArr[i] |= 1 << (arrStr[i].charAt(j) - 'a');
            }
        }

        return combination(-1,0, K, basicSelected, bitArr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        String [] arrStr = new String[N];

        for(int i = 0; i < N; ++i){
            arrStr[i] = br.readLine();
        }

        if(K < 5){
            System.out.println(0);
        }else{
            System.out.print(sol(N, K, arrStr));
        }
    }
}
