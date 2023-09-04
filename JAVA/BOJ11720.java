import java.util.Scanner;

public class BOJ11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long ret = 0;
        int N = scanner.nextInt();

        String str = scanner.next();

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            ret += num;
        }

        System.out.println(ret);
    }
}
