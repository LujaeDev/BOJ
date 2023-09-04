import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), ret =0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if(N >= 3){
            for (int i = 0; i < N; ++i) {
                int p1 = 0, p2 = N - 1;
                int tmpSum = 0;

                while (p1 < p2) {
                    tmpSum = arr[p1] + arr[p2];

                    if(tmpSum < arr[i])
                        p1++;
                    else if (tmpSum > arr[i])
                        p2--;
                    else{
                        if(p1 == i || p2 == i){
                            if(p1 == i)
                                p1++;
                            else
                                p2--;

                            continue;
                        }

                        ret++;
                        break;
                    }
                }
            }
        }

        System.out.println(ret);
    }
}
