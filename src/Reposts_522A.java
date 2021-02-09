import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/522/A
 */
public class Reposts_522A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, List<String>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] l = br.readLine().split("\\s");
            String a = l[0].toLowerCase();
            String b = l[2].toLowerCase();
            if (!adj.containsKey(a)) {
                adj.put(a, new ArrayList<>());
            }
            if (!adj.containsKey(b)) {
                adj.put(b, new ArrayList<>());
            }
            adj.get(b).add(a);
        }
        System.out.println(dfs("polycarp", adj));
    }

    static int dfs(String start, Map<String, List<String>> adj) {
        int dist = 0;
        List<String> edges = adj.get(start);
        if (edges == null) return dist+ 1;
        for (String s : edges) {
            dist = Math.max(dfs(s, adj), dist);
        }
        return dist + 1;
    }
}
