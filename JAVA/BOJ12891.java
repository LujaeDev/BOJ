import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int ret = 0;
        int[]cnt = new int[4], minCnt = new int[4];

        HashMap<Character, Integer> converter = new HashMap<>();

        String s = br.readLine();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; ++i) {
            minCnt[i] = Integer.parseInt(st.nextToken());
        }

        converter.put('A', 0);
        converter.put('C', 1);
        converter.put('G', 2);
        converter.put('T', 3);

        int start = 0;

        for (int i = 0; i < P; ++i) {
            char tmp = s.charAt(i);
            int index = converter.get(tmp);

            cnt[index]++;
        }

        while (start + P <= N) {
            boolean flag = true;

            for (int i = 0; i < 4; ++i) {
                if(cnt[i] < minCnt[i])
                    flag = false;
            }

            if (flag)
                ret++;

            char startCh = s.charAt(start);
            int index1 = converter.get(startCh);
            cnt[index1]--;


            if(start + P < N) {
                char endCh = s.charAt(start + P);
                int index2 = converter.get(endCh);
                cnt[index2]++;
            }

            start++;
        }

        System.out.println(ret);
    }
}
