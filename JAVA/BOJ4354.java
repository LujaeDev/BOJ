import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ4354 {
    public static ArrayList<Integer>getPartialMatch(final String N){
        int m = N.length(), begin = 1, matched = 0;
        ArrayList<Integer> pi = new ArrayList<Integer>(Collections.nCopies(m, 0));

        while(begin + matched < m){
            if(N.charAt(begin + matched) == N.charAt(matched)) {
                matched++;
                pi.set(begin + matched - 1, matched);
            }else{
                if(matched == 0){
                    begin++;
                }else{
                    begin += matched - pi.get(matched - 1);
                    matched = pi.get(matched - 1);
                }
            }
        }

        return pi;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String s = br.readLine();

            if(s.equals(".")){
                break;
            }

            ArrayList<Integer> pi = getPartialMatch(s);
            int len = s.length();
            int miniWordSize = len - pi.get(len - 1);

            if(len % miniWordSize == 0)
                System.out.println(len / miniWordSize);
            else
                System.out.println(1);
        }
    }
}
