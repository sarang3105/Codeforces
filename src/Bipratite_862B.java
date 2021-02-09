import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/862/B
 **/
public class Bipratite_862B {
    static final int RED = 0;
    static final int BLUE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] s = sc.readLine().split("\\s");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        BigInteger[] colorCount = new BigInteger[2];
        colorCount[RED] = BigInteger.ZERO;
        colorCount[BLUE] = BigInteger.ZERO;
        colorGraph(graph, new boolean[n + 1],1, RED, colorCount);
        System.out.println(colorCount[BLUE].multiply(colorCount[RED]).subtract((BigInteger.valueOf(n - 1))));
    }

    static void colorGraph(List<Integer>[] graph, boolean[] vis, int vertex, int currColor, BigInteger[] colorCount) {
        if (vis[vertex]) return;
        List<Integer> edges = graph[vertex];
        if (edges == null) return;
        int next = (currColor == RED) ? BLUE : RED;
        vis[vertex] = true;
        colorCount[currColor] = colorCount[currColor].add(BigInteger.ONE);
        for (Integer i : edges) {
            colorGraph(graph, vis, i, next, colorCount);
        }
    }
}
