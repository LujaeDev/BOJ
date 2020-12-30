import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ1305 {
    static ArrayList<Integer> getPartialMatch(final String s){
        int m = s.length();
        ArrayList<Integer> ret = new ArrayList<Integer>(Collections.nCopies(s.length(), 0));
        int begin = 1, match = 0;

        while(begin + match < m){
            if(s.charAt(begin + match) == s.charAt(match)){
                match++;
                ret.set(begin + match - 1, match);
            }
            else{
                if(match == 0){
                    begin++;
                }else{
                    begin += match - ret.get(match - 1);
                    match = ret.get(match - 1);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> pi = getPartialMatch(br.readLine());
        int pos = n - 1;

        pos -= pi.get(pos);

        System.out.print(pos + 1);
    }
}
