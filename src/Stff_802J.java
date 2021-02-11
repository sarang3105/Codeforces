import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/802/J
 */
public class Stff_802J {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Node>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split("\\s");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            graph[u].add(new Node(w, v));
            graph[v].add(new Node(w, u));
        }
        System.out.println(dfs(graph, 0, new boolean[n]));
    }

    private static int dfs(List<Node>[] graph, int s, boolean[] vis) {
        vis[s] = true;
        List<Node> edges = graph[s];
        int max = 0;
        if (edges != null) {
            for (Node e : edges) {
                if (!vis[e.v]) {
                    max = Math.max(dfs(graph, e.v, vis) + e.w, max );
                }
            }
        }
        return max;
    }

    static class Node {
        int w;
        int v;

        public Node(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
