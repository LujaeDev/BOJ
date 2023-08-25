import java.util.Scanner;

public class BOJ11659 {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt(), M = scanner.nextInt();
        long[] s = new long[N + 1];
        scanner.nextLine();
        String[] arrSp = scanner.nextLine().split(" ");

        s[0] = 0;
        for (int i = 1; i <= arrSp.length; ++i) {
            int num = Integer.parseInt(arrSp[i - 1]);
            s[i] = s[i - 1] + num;
        }

        for (int i = 0; i < M; ++i) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            System.out.println(s[end] - s[start - 1]);
        }

        scanner.close();
    }

}
