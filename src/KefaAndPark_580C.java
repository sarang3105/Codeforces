import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/580/C
 */
public class KefaAndPark_580C {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split("\\s");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] cats = br.readLine().split("\\s");

        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] ve = br.readLine().split("\\s");
            int u = Integer.parseInt(ve[0]) - 1;
            int v = Integer.parseInt(ve[1]) - 1;
            tree[u].add(v);
            tree[v].add(u);
        }
        int[] paths = new int[1];
        dfs(tree, 0, 0, Integer.parseInt(cats[0]), cats, m, paths);
        System.out.println(paths[0]);
    }

    private static void dfs(List<Integer>[] g, int start, int parent, int totalCats, String[] cats, int m, int[] paths) {
        if (cats[start].equals("1") && start != 0) totalCats = totalCats + 1;
        if (!cats[start].equals("1")) totalCats = 0;
        if (totalCats > m) return;
        if (g[start].size() == 1 && g[start].get(0) == parent) {
            paths[0]++;
            return;
        }
        for (Integer edge : g[start]) {
            if (edge != parent) {
                dfs(g, edge, start, totalCats, cats, m, paths);
            }
        }
    }
}
