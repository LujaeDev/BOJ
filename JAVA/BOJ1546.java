import java.util.Collections;
import java.util.Scanner;

public class BOJ1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        double[] arr = new double[N];

        for(int i = 0; i < N; ++i){
            arr[i] = scanner.nextDouble();
        }

        double maxScore = maxValue(arr);

        double total = 0;

        for (int i = 0; i < arr.length; ++i) {
            total += arr[i] / maxScore * 100;
        }

        double ret = total / arr.length;

        System.out.printf("%.3f", ret);
    }

    private static double maxValue(double[] arr) {
        double ret = -10;

        for (int i = 0; i < arr.length; ++i) {
            ret = Math.max(ret, arr[i]);
        }

        return ret;
    }
}
