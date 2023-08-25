import java.io.*;
import java.util.Comparator;
import java.util.HashSet;

public class BOJ7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> hashSet = new HashSet<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; ++i) {
            String[] parts = br.readLine().split(" ");

            String name = parts[0];
            String state = parts[1];

            if (state.equals("enter")) hashSet.add(name);
            else hashSet.remove(name);
        }

        hashSet.stream().sorted(Comparator.reverseOrder()).forEach(s -> {
            try {
                bw.write(s + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        br.close();
        bw.close();
    }
}
