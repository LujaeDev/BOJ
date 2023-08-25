import java.io.*;
import java.util.HashSet;

public class BOJ14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = br.readLine().split(" ");
        HashSet<String> set = new HashSet();

        int N = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);
        int ret = 0;

        for (int i = 0; i < N; ++i) {
            String str = br.readLine();

            set.add(str);
        }

        for (int i = 0; i < M; ++i) {
            String str = br.readLine();

            if (set.contains(str)) ret++;
        }

        bw.write(Integer.toString(ret));

        bw.close();
        br.close();
    }
}
