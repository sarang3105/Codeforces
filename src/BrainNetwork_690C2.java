import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/690/C2
 */
public class BrainNetwork_690C2 {

    private static Map<Integer, List<Integer>> adj;
    private static int n;
    private static int m;
    private static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split("\\s");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        adj = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] uv = br.readLine().split("\\s");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(1, 0, new HashSet<>());
        System.out.println(max);
    }


    private static int dfs(int start, int parent, Set<Integer> vis) {
        vis.add(start);
        if (adj.get(start).size() == 1 && adj.get(start).get(0).equals(parent)) {
            return 0;
        }
        int max1 = -1, max2 = -1;
        for (Integer i : adj.get(start)) {
            if (vis.contains(i))  continue;
            int val = dfs(i, start, vis);
            if(max1 < val){
                max2 = max1;
                max1 = val;
            } else if(max2 < val){
                max2 = val;
            }
        }

        if (max1 == -1) {
            max = Math.max( 1 + max2, max);
            return 1 + max2;
        } else if (max2 == -1) {
            max = Math.max(1 + max1, max);
            return 1 + max1;
        }
        max = Math.max(max, 2 + max1 + max2);
        return Math.max(1 + max1, 1 +  max2);
    }
}