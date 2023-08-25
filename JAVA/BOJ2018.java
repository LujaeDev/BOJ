import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int start = 0, end = 0, ret = 0;
        long tmpSum = 0;

        while(end <= N && start <= end){
            tmpSum = sigma(end) - sigma(start);

            if(tmpSum < N)
                end++;
            else if(tmpSum > N)
                start++;
            else{
                ret++;
                start++;
            }
        }

        System.out.println(ret);
    }

    private static long sigma(int n) {
        return (long)n * (n + 1) / 2;
    }
}
