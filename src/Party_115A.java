import java.util.LinkedList;
import java.util.Scanner;
/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/115/A
 */
public class Party_115A {
    static int c = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer>[] adj = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int i = 1; i <= n; i++) {
            int e = sc.nextInt();
            if (e == -1) continue;
            adj[i].add(e);
        }
        for (int i = 1; i <= n; i++) {
            dfs(1, i, adj);
        }
        System.out.println(c);

    }

    static void dfs(int level, int v, LinkedList<Integer>[] adj) {
        c = Math.max(c, level);
        for (Integer i : adj[v]) {
                dfs(level + 1, i, adj);
        }
    }
}
