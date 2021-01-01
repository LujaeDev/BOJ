import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOJ11479 {
    static private class Com implements Comparator<Integer> {
        ArrayList<Integer> group;
        int t;

        Com(ArrayList<Integer> _group, int _t){
            group = _group;
            t = _t;
        }

        @Override
        public int compare(Integer a, Integer b) {
            if(group.get(a) != group.get(b)){
                return group.get(a) - group.get(b);
            }else{
                return group.get(a + t) - group.get(b + t);
            }
        }
    }

    static ArrayList<Integer> getSuffixTable(final String s){
        int n = s.length();
        ArrayList<Integer> group = new ArrayList<Integer>(Collections.nCopies(n + 1, 0));
        ArrayList<Integer> ret = new ArrayList<Integer>(Collections.nCopies(n, 0));

        for(int i = 0; i < n; ++i){
            group.set(i, s.charAt(i) - 'a');
        }
        group.set(n, -1);

        for(int i = 0; i < n; ++i){
            ret.set(i, i);
        }

        int t = 1;

        while(t < n){
            Com com = new Com(group, t);

            Collections.sort(ret, com);

            t *= 2;

            if(t >= n){
                break;
            }

            ArrayList<Integer> newGroup = new ArrayList<Integer>(Collections.nCopies(n + 1, 0));
            newGroup.set(n, -1);
            newGroup.set(ret.get(0), 0);

            for(int i = 1; i < n; ++i){
                if(com.compare(ret.get(i - 1), ret.get(i)) != 0){
                    newGroup.set(ret.get(i), newGroup.get(ret.get(i -1)) + 1);
                }else{
                    newGroup.set(ret.get(i), newGroup.get(ret.get(i -1)));
                }
            }

            group = newGroup;
        }

        return ret;
    }

    static ArrayList<Integer> getLCP(final String s, ArrayList<Integer> suffixTable){
        int h = 0, n = s.length();
        int [] rank = new int[n], a = new int[n];
        ArrayList<Integer> ret = new ArrayList<Integer>(Collections.nCopies(n, 0));

        for(int i = 0; i < n; ++i){
            rank[suffixTable.get(i)] = i;
        }

        for(int i = 0; i < s.length(); ++i){
            int k = rank[i];

            if(k != 0){
                int j = suffixTable.get(k - 1);

                while(i + h < n && j + h < n && s.charAt(j + h) == s.charAt(i + h)){
                    h++;
                }

                ret.set(k, h);

                if(h != 0)
                    h--;
            }
        }

        return ret;
    }

    static long sol(final String s){
        long ret = 0;
        ArrayList<Integer> suffixTable = getSuffixTable(s);
        ArrayList<Integer> LCP = getLCP(s, suffixTable);

        ret += s.length() - suffixTable.get(0);
        for(int i = 1; i < suffixTable.size(); ++i){
            int subStringlen = s.length() - suffixTable.get(i);
            ret += subStringlen;

            ret -= LCP.get(i);
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.print(sol(s));
    }
}
