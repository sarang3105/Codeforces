import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/212/E
 */
public class ITRestaurants_212E {

    private static Map<Integer, Integer> ans = new TreeMap<>();
    private static List<Integer>[] adj;
    private static int n;

    public static void main(String[] args) throws Exception {
        FastReader br = new FastReader();
        n = br.nextInt();

        adj = new ArrayList[n];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = br.nextInt() - 1;
            int v = br.nextInt() - 1;
            adj[u].add(v);
            adj[v].add(u);
        }


        for (int i = 0; i < n; i++) {
            int[] count = new int[n];
            if (adj[i].size() == 1) continue;
            dfs(i, new boolean[n], i, count);
            combinations(count, i, n - 1);
        }
        System.out.println(ans.size());
        for (Map.Entry<Integer, Integer> a : ans.entrySet()) {
            System.out.println(a.getKey() +" "+ a.getValue());
        }
    }

    private static void dfs(int start, boolean[] vis, int parent, int[] count) {
        vis[start] = true;
        count[start] = 1;
        for (Integer i: adj[start]) {
            if (i == parent) continue;
            if (vis[i]) continue;
            dfs(i, vis, start, count);
            count[start] += count[i];

        }
    }

    private static void combinations(int[] count, int root, int n) {
        List<Integer> a = new ArrayList<>();
        for (Integer i : adj[root]) {
            a.add(count[i]);
        }
        int sum = 0;
        for (Integer i: a) {
            sum += i;
            if (sum != n) {
                ans.put(sum, n - sum);
                ans.put(n - sum, sum);
            }
            ans.put(i, n - i);
            ans.put(n - i, i);
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
