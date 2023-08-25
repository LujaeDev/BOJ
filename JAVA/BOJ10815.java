import java.io.*;
import java.util.Arrays;

public class BOJ10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String inputLine1 = br.readLine();
        int[] myNumbers = getNumbers(inputLine1);
        int[] lookupTable = new int[20000001];

        for (int myNumber : myNumbers) {
            lookupTable[myNumber + 10000000] = 1;
        }


        int m = Integer.parseInt(br.readLine());
        String inputLine2 = br.readLine();

        Arrays.stream(inputLine2.split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(number -> {
                            try {
                                bw.write(lookupTable[number + 10000000] + " ");
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }

                );

        bw.close();
        br.close();
    }

    private static int[] getNumbers(String inputLine) {
        return Arrays.stream(inputLine.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
