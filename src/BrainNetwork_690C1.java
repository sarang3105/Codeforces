import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/690/C1
 */
public class BrainNetwork_690C1 {
    private static Map<Integer, List<Integer>> adj;
    private static int n;
    private static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split("\\s");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        adj = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String[] uv = br.readLine().split("\\s");
            int u = Integer.parseInt(uv[0]) - 1;
            int v = Integer.parseInt(uv[1]) - 1;
            if (!adj.containsKey(u)) adj.put(u, new ArrayList<>());
            if (!adj.containsKey(v)) adj.put(v, new ArrayList<>());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        solutionOne();
    }

    private static void dfsOne(Map<Integer, List<Integer>> adj, Map<Integer, Boolean> vis, int start, int parent) {
        vis.put(start, true);
        for (Integer i : adj.get(start)) {
            if (vis.containsKey(i) && vis.get(i)) continue;
            dfsOne(adj, vis, i, parent);
        }
    }

    private static void solutionOne() {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        dfsOne(adj, vis, (int) adj.keySet().toArray()[0], 0);
        if (m != n - 1 || adj.keySet().size() < n || vis.keySet().size() != adj.keySet().size()) {
            System.out.println("no");
            return;
        }
        System.out.println("yes");
    }

    private static void solutionTwo() {
        if(m != n - 1) {
            System.out.println("no");
            return;
        }
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (Integer i : adj.keySet()) {
            if (!vis.containsKey(i) && findCycle(vis, i, 0)) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }

    private static boolean findCycle(Map<Integer, Boolean> vis, int start, int parent) {
        vis.put(start, true);
        for (Integer i : adj.get(start)) {
            if (!vis.containsKey(i)) {
                if (findCycle(vis, i, start)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }

        }
        return false;
    }
}
