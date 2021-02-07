import java.util.Scanner;
/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/1033/A
 */
public class KingEscape_1033A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ax = sc.nextInt() - 1;
        int ay = sc.nextInt() - 1;

        int bx = sc.nextInt() - 1;
        int by = sc.nextInt() - 1;

        int cx = sc.nextInt() - 1;
        int cy = sc.nextInt() - 1;

        int[][] board = new int[n][n];

        possibleQueenPos(board, ax, ay, n);
        boolean ans = dfs(board, bx, by, cx, cy, n);
        System.out.println((ans) ? "YES" : "NO");
    }

    static boolean dfs(int[][] board, int bx, int by, int cx, int cy, int n) {
        board[bx][by] = 1;
        if (cx == bx && cy == by) {
            return true;
        }
        if (bx + 1 < n && board[bx + 1][by] == 0) {
            boolean ans = dfs(board, bx + 1, by, cx, cy, n);
            if (ans) return ans;
        }
        if (bx - 1 >= 0 && board[bx - 1][by] == 0) {
            boolean ans = dfs(board, bx - 1, by, cx, cy, n);
            if (ans) return ans;

        }
        if (by - 1 >= 0 && board[bx][by - 1] == 0) {
            boolean ans = dfs(board, bx, by - 1, cx, cy, n);
            if (ans) return ans;

        }
        if (by + 1 < n && board[bx][by + 1] == 0) {
            boolean ans = dfs(board, bx, by + 1, cx, cy, n);
            if (ans) return ans;

        }
        if (bx + 1 < n && by + 1 < n && board[bx + 1][by + 1] == 0) {
            boolean ans = dfs(board, bx + 1, by + 1, cx, cy, n);
            if (ans) return ans;

        }
        if (bx + 1 < n && by - 1 >= 0 && board[bx + 1][by - 1] == 0) {
            boolean ans = dfs(board, bx + 1, by - 1, cx, cy, n);
            if (ans) return ans;

        }
        if (bx - 1 >= 0 && by -1 >= 0 && board[bx - 1][by - 1] == 0) {
            boolean ans = dfs(board, bx - 1, by - 1, cx, cy, n);
            if (ans) return ans;

        }
        if (bx - 1 >= 0 && by + 1 < n && board[bx - 1][by + 1] == 0) {
            boolean ans = dfs(board, bx - 1, by + 1, cx, cy, n);
            if (ans) return ans;

        }
        return false;
    }

    static void possibleQueenPos(int[][] board, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            board[row][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            board[i][col] = 1;
        }

        int c = col;
        for (int i = row; i < n; i++) {
            if (c >= n) {
                break;
            }
            board[i][c] = 1;
            c++;
        }
        c = col;
        for (int i = row; i < n; i++) {
            if (c < 0) {
                break;
            }
            board[i][c] = 1;
            c--;
        }
        c = col;
        for (int i = row; i >= 0; i--) {
            if (c < 0) {
                break;
            }
            board[i][c] = 1;
            c--;
        }
        c = col;
        for (int i = row; i >= 0; i--) {
            if (c >= n) {
                break;
            }
            board[i][c] = 1;
            c++;
        }
    }
}
