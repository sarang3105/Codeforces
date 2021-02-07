import java.util.LinkedList;
import java.util.Scanner;
/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/500/A
 */
public class NewYearTransportation_500A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();

        LinkedList<Integer>[] adj = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int i = 1; i < n; i++) {
            adj[i].add(i + sc.nextInt());
        }
        boolean[] visited = new boolean[n + 1];
        boolean ans = dfs(visited, adj, 1, t);
        System.out.println((ans) ? "YES" : "NO");
    }

    static boolean dfs(boolean[] visted, LinkedList<Integer>[] adj, int v, int t) {
        visted[v] = true;
        if (v == t) {
            return true;
        }
        for (Integer i : adj[v]) {
            if (visted[i]) continue;
            return dfs(visted, adj, i, t);
        }
        return false;
    }
}
