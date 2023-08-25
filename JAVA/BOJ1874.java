import java.io.*;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()), value = 1, index=0;
        int[] arr = new int[N];
        char[] ret = new char[2 * N + 1];
        Stack<Integer> s = new Stack<>();


        for(int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; ++i) {

            while (s.empty() || s.peek() < arr[i]) {
                s.push(value++);
                ret[index++] = '+';
            }

            if(s.peek() == arr[i]){
                s.pop();
                ret[index++] = '-';
            }
            else{
                break;
            }
        }

        if(index == 2*N){
            for(int i = 0; i < index; ++i){
                bw.write(ret[i] + "\n");
            }
        }else{
            bw.write("NO");
        }

        br.close();
        bw.close();
    }
}
