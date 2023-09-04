import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ1427 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));

        int[] cnt = new int[10];
        String num = sc.next();
        String ret = "";

        for (int i = 0; i < num.length(); ++i) {
            char ch = num.charAt(i);
            cnt[ch - '0']++;
        }

        for (int i = 9; i >= 0; --i) {
            ret += Integer.toString(i).repeat(cnt[i]);
        }

        System.out.println(ret);
        sc.close();
    }
}
