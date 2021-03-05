import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @link https://codeforces.com/contest/1494/problem/E
 */
public class AZGraph_1494E {

    private static int n = 0;
    private static Map<List<Integer>, Integer> graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split("\\s");
        n = Integer.parseInt(nm[0]);
        graph = new HashMap<>();
        int m = Integer.parseInt(nm[1]);
        int pair = 0;
        int diff = 0;
        while (m-- > 0) {
            String[] query = br.readLine().split("\\s");
            String operation = query[0];
            if (operation.equals("+")) {
                int u = Integer.parseInt(query[1]) - 1;
                int v = Integer.parseInt(query[2]) - 1;
                int c = query[3].charAt(0);
                if (graph.containsKey(Arrays.asList(v, u))) {
                    diff++;
                    if (graph.get(Arrays.asList(v, u)) == c) {
                        pair++;
                    }
                }
                graph.put(Arrays.asList(u, v), c);
            } else if (operation.equals("-")) {
                int u = Integer.parseInt(query[1]) - 1;
                int v = Integer.parseInt(query[2]) - 1;
                if (graph.containsKey(Arrays.asList(v, u))) {
                    diff--;
                    if (graph.get(Arrays.asList(v, u)).equals(graph.get(Arrays.asList(u, v)))){
                        pair--;
                    }
                }
                graph.remove(Arrays.asList(u, v));
            } else {
                int k = Integer.parseInt(query[1]);
                boolean ans = false;
                if (k % 2 == 0) {
                    if (pair > 0) {
                        ans = true;
                    }
                }
                if (k % 2 != 0) {
                    if (pair > 0 || diff > 0) {
                        ans = true;
                    }
                }

                if (ans) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
