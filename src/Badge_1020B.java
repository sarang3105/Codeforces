import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/1020/B
 */
public class Badge_1020B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer>[] adj = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i = 1; i <= n; i++) {
            adj[i].add(sc.nextInt());
        }

        for (int i = 1; i <= n; i++) {
            dfs(new boolean[n + 1], i, adj);
        }
    }

    static void dfs(boolean[] vis, int v, LinkedList<Integer>[] adj) {
        vis[v] = true;
        for (Integer i : adj[v]) {
            if (vis[i]) {
                System.out.print(i + " ");
                return;
            }
            dfs(vis, i, adj);
        }
    }
}
