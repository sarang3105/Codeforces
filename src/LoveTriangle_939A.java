import java.util.LinkedList;
import java.util.Scanner;
/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/939/A
 */
public class LoveTriangle_939A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer>[] adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            adj[i].add(sc.nextInt() - 1);
        }

        boolean ans = false;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]){
                int c = dfs(i, vis, adj, i);
                if (c == 3) {
                    ans = true;
                    break;
                }
            }
        }

        System.out.println((ans) ? "YES" : "NO");

    }

    static int dfs(int v, boolean[] visited, LinkedList<Integer>[] adj, int start) {
        visited[v] = true;
        int count = 0;
        for (Integer i : adj[v]) {
            if (visited[i] && i == start) {
                return count + 1;
            }
            if (!visited[i]) {
               count=  dfs(i, visited, adj, start);
               return count + 1;
            }
        }
        return count;
    }

}
