import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BOJ1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] parts = br.readLine().split(" ");

        int cntA = Integer.parseInt(parts[0]);
        int cntB = Integer.parseInt(parts[1]);

        Set<String> collectA = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toSet());
        Set<String> collectAClone = new HashSet<>(collectA);
        Set<String> collectB = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toSet());

        collectA.removeAll(collectB);
        collectB.removeAll(collectAClone);

        collectA.addAll(collectB);

        bw.write(Integer.toString(collectA.size()));

        br.close();
        bw.close();
    }
}
