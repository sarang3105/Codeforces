import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/1255/B
 */
public class FridgeLockers_1255B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();

            int[] w = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
            }

            if (c < n || n == 2) {
                System.out.println(-1);
                continue;
            }

            int total = 0;
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    edges.add(new Edge(i, 0, w[0] + w[i]));
                    total += w[0] + w[i];
                } else {
                    edges.add(new Edge(i, i + 1, w[i + 1] + w[i]));
                    total += w[i] + w[i + 1];
                }
                c--;
            }

            for (int i = 0; i < c; i++) {
                int curr = Integer.MAX_VALUE;
                Edge edge = null;
                for (int e = 0; e < n; e++) {
                    for (int k = e + 1; k < n; k++) {
                        int we = w[e] + w[k];
                        if (we < curr) {
                            curr = we;
                            edge = new Edge(e, k, curr);
                        }
                    }
                }
                if (edge != null) {
                    edges.add(edge);
                    total += curr;
                }
            }
            System.out.println(total);
            for (Edge e : edges) {
                System.out.println((e.src + 1) + " " + (e.vertex + 1));
            }
        }
    }

    static class Edge {
        int src, vertex, w;

        public Edge(int src, int vertex, int w) {
            this.src = src;
            this.vertex = vertex;
            this.w = w;
        }
    }
}
