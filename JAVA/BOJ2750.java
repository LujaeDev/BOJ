import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2750 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = readInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; ++i) {
            arr[i] = readInt();
        }

        for (int i = N - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if(arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }

        for(int i = 0; i < N; ++i)
            System.out.println(arr[i]);
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static int readInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
