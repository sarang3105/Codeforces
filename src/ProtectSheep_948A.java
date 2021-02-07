import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/948/A
 */
public class ProtectSheep_948A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        int R = Integer.parseInt(rc[0]);
        int C = Integer.parseInt(rc[1]);

        char[][] g = new char[R][C];
        for (int i = 0; i < R; i++) {
            g[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (g[i][j] == 'S' &&
                        ((j + 1 < C && g[i][j + 1] == 'W') ||(i + 1 < R && g[i + 1][j] == 'W') || (i - 1 >= 0 && g[i - 1][j] == 'W') || (j - 1 >= 0 && g[i][j - 1] == 'W'))) {
                    System.out.println("No");
                    return;
                }
                if (g[i][j] == 'S') {
                    if (j - 1 >= 0 && g[i][j - 1] == '.')
                        g[i][j - 1] = 'D';
                    if (j + 1 < C && g[i][j + 1] == '.')
                        g[i][j + 1] = 'D';
                    if (i - 1 >= 0 && g[i - 1][j] == '.')
                        g[i - 1][j] = 'D';
                    if (i + 1 < R && g[i + 1][j] == '.')
                        g[i + 1][j] = 'D';
                }
            }
        }
        System.out.println("Yes");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(g[i][j]);
            }
            System.out.println();
        }

    }

/*    static boolean dfs(int i, int j, int R, int C, char[][] g, boolean[][] vis) {
        vis[i][j] = true;
        if (g[i][j] == 'D') return true;

        if (i - 1 >= 0 && !vis[i - 1][j]) {
            if (g[i - 1][j] == 'S' && g[i][j] == 'W') return false;
            if (g[i - 1][j] == 'S') {
                g[i][j] = 'D';
            } else {
                boolean ans = dfs(i - 1, j, R, C, g, vis);
                vis[i][j] = false;
                if (!ans) return false;

            }
        }

        if (i + 1 < R && !vis[i + 1][j]) {
            if (g[i + 1][j] == 'S' && g[i][j] == 'W') return false;

            if (g[i + 1][j] == 'S') {
                g[i][j] = 'D';
            } else {
                boolean ans = dfs(i + 1, j, R, C, g, vis);
                vis[i][j] = false;
                if (!ans) return false;
            }
        }

        if (j - 1 >= 0 && !vis[i][j - 1]) {
            if (g[i][j - 1] == 'S' && g[i][j] == 'W') return false;

            if (g[i][j - 1] == 'S') {
                g[i][j] = 'D';
            } else {
                boolean ans = dfs(i, j - 1, R, C, g, vis);
                vis[i][j] = false;
                if (!ans) return false;

            }
        }

        if (j + 1 < C && !vis[i][j + 1]) {
            if (g[i][j + 1] == 'S' && g[i][j] == 'W') return false;

            if (g[i][j + 1] == 'S') {
                g[i][j] = 'D';
            } else {
                boolean ans = dfs(i, j + 1, R, C, g, vis);
                vis[i][j] = false;
                if (!ans) return false;

            }
        }
        return true;
    }*/
}
