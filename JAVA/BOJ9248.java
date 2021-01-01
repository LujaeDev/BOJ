import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOJ9248 {
    static class Com implements Comparator<Integer> {
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
        int n = s.length(), t = 1;

        ArrayList<Integer> ret = new ArrayList<Integer>(Collections.nCopies(n, 0));
        ArrayList<Integer> group = new ArrayList<Integer>(Collections.nCopies(n + 1, 0));

        for(int i = 0 ; i < n; ++i){
            ret.set(i, i);
            group.set(i, s.charAt(i) - 'a');
        }
        group.set(n, -1);

        while(t < n){
            Com com = new Com(group, t);

            Collections.sort(ret, com);

            t *= 2;

            ArrayList<Integer> newGroup = new ArrayList<Integer>(Collections.nCopies(n + 1, 0));
            newGroup.set(n, -1);
            newGroup.set(ret.get(0), 0);

            for(int i = 1; i < n; ++i){
                if(com.compare(ret.get(i - 1), ret.get(i)) != 0){
                    newGroup.set(ret.get(i), newGroup.get(ret.get(i - 1)) + 1);
                }else{
                    newGroup.set(ret.get(i), newGroup.get(ret.get(i - 1)));
                }
            }

            group = newGroup;
        }

        return ret;
    }

    static ArrayList<Integer> getLCPTable(final String s, ArrayList<Integer> suffixTable){
        int n = s.length(), h = 0;
        int []rank = new int[n];
        ArrayList<Integer> ret = new ArrayList<Integer>(Collections.nCopies(n, 0));

        for(int i = 0; i < n; ++i){
            rank[suffixTable.get(i)] = i;
        }

        for(int i = 0; i < n; ++i){
            int k = rank[i];

            if(k != 0){
                int j = suffixTable.get(k - 1);

                while(i + h < n && j + h < n && s.charAt(i + h) == s.charAt(j + h)){
                    h++;
                }

                ret.set(k, h);

                if(h != 0){
                    h--;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        ArrayList<Integer> suffixTable = getSuffixTable(s);
        ArrayList<Integer> lcpTable = getLCPTable(s, suffixTable);

        for(int i = 0; i < s.length(); ++i){
            bw.write((suffixTable.get(i) + 1) + " ");
        }
        bw.write("\n");
        bw.write("x ");
        for(int i = 1; i < s.length(); ++i){
            bw.write(lcpTable.get(i) + " ");
        }
        bw.close();
    }
}
