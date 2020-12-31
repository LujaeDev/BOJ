import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ10266 {
    static ArrayList<Integer> getPiTable(final String s){
        int n = s.length();
        int begin = 1, matched = 0;
        ArrayList<Integer> pi = new ArrayList<Integer>(Collections.nCopies(n, 0));

        while(begin + matched < n){
            if(s.charAt(begin + matched) == s.charAt(matched)){
                matched++;
                pi.set(begin + matched - 1, matched);
            }else{
                if(matched == 0) {
                    ++begin;
                }else{
                    begin += matched - pi.get(matched - 1);
                    matched = pi.get(matched - 1);
                }
            }
        }

        return pi;
    }

    static int firstKMP(final String H, final String N){
        int m = H.length(), n = N.length();
        int begin = 0, matched = 0;

        ArrayList<Integer> pi = getPiTable(N);

        while(begin <= m - n){
            if(matched < n && H.charAt(begin + matched) == N.charAt(matched)){
                matched++;

                if(matched == n)
                    return begin;
            }else{
                if(matched == 0){
                    ++begin;
                }else{
                    begin += matched - pi.get(matched - 1);
                    matched = pi.get(matched - 1);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder H = new StringBuilder(""), N = new StringBuilder("");

        for(int i = 0; i < 360000; ++i){
            H.append("0");
            N.append("0");
        }

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {
            H.setCharAt(Integer.parseInt(st.nextToken()), '1');
        }


        st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()){
            N.setCharAt(Integer.parseInt(st.nextToken()), '1');
        }

        H.append(H);

        int flag = firstKMP(H.toString(), N.toString());

        if(flag == -1){
            System.out.println("impossible");
        }else{
            System.out.println("possible");
        }
    }
}
