import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ1786 {
    public static ArrayList<Integer>getPartialMatch(final String N){
        int m = N.length();
        int begin = 1, match = 0;
        ArrayList<Integer>pi = new ArrayList<Integer>(Collections.nCopies(m, 0));

        while(begin + match < m){
            if(N.charAt(begin + match) == N.charAt(match)){
                match++;
                pi.set(begin + match - 1, match);
            }
            else{
                if(match == 0){
                    begin++;
                }else{
                    begin += match - pi.get(match - 1);
                    match = pi.get(match - 1);
                }
            }
        }

        return pi;
    }

    public static ArrayList<Integer>KMP(final String H, final String N){
        ArrayList<Integer> pi = getPartialMatch(N);
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int m = H.length(), n = N.length(), begin = 0, match = 0;

        while(begin <= m - n){
            if(match < n && H.charAt(begin + match) == N.charAt(match)) {
                match++;

                if (match == n) {
                    ret.add(begin);
                }
            }else{
                if(match == 0){
                    begin++;
                }else{
                    begin += match - pi.get(match - 1);
                    match = pi.get(match - 1);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));

        String H = br.readLine();
        String N = br.readLine();

        ArrayList<Integer> ret = KMP(H, N);

        bw.write(ret.size() + "\n");
        for(Integer i : ret){
            bw.write((i + 1) + "\n");
        }

        br.close();
        bw.close();
    }
}
