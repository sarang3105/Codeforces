import java.io.*;
import java.lang.*;
import java.math.BigInteger;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/1336/A
 */
public class LinovaAndKingdom_1336A {

    private static List<Integer>[] adj;
    private static int n;
    private static int m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split("\\s");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] uv = br.readLine().split("\\s");
            int u = Integer.parseInt(uv[0]) - 1;
            int v = Integer.parseInt(uv[1]) - 1;
            adj[u].add(v);
            adj[v].add(u);
        }
        PriorityQueue<BigInteger> pq = new PriorityQueue<>(new Comparator<BigInteger>() {
            @Override
            public int compare(BigInteger o1, BigInteger o2) {
                return o2.subtract(o1).intValue();
            }
        });
        BigInteger[][] hs = new BigInteger[2][n];
        for (int i = 0; i < n; i++) {
            hs[0][i] = BigInteger.ZERO;
            hs[1][i] = BigInteger.ZERO;
        }
        dfs(0, hs, 0, new boolean[n]);
        bfs(0, hs);

        for (int i = 0; i < n; i++) {
            pq.add(hs[0][i].subtract(hs[1][i].subtract(BigInteger.ONE)));
        }
        BigInteger sum = BigInteger.ZERO;
        while (m != 0) {
            sum = sum.add(pq.poll());
            m--;
        }
        System.out.println(sum);
    }

    private static void dfs(int start, BigInteger[][] hs, int curr, boolean[] vis) {
        vis[start] = true;
        hs[1][start] = hs[1][start].add(BigInteger.ONE);
        for (Integer i: adj[start]) {
            if(vis[i]) continue;
            dfs(i, hs, curr + 1, vis);

            hs[1][start] = hs[1][start].add(hs[1][i]);
        }
    }

    private static void bfs(int start, BigInteger[][] hs) {
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        BigInteger level = BigInteger.ZERO;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int v = q.poll();
                for (Integer i : adj[v]) {
                    if (vis[i]) continue;
                    vis[i] = true;
                    q.add(i);
                }
                hs[0][v] = level;
            }
            level = level.add(BigInteger.ONE);
        }
    }
}
