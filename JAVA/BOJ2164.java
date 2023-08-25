import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i <= N; ++i) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.removeFirst();

            int topValue = q.pollFirst();
            q.add(topValue);
        }

        System.out.println(q.get(0));
    }
}
