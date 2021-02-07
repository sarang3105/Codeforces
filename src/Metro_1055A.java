import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://codeforces.com/problemset/problem/1055/A
 */
public class Metro_1055A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nc = br.readLine().split("\\s");
        int N = Integer.parseInt(nc[0]);
        int M = Integer.parseInt(nc[1]);

        int[][] tracks = new int[2][N + 1];
        String[] t1 = br.readLine().split("\\s");
        String[] t2 = br.readLine().split("\\s");
        for (int i = 1; i <= N; i++) {
            tracks[0][i] = Integer.parseInt(t1[i - 1]);
        }
        for (int i = 1; i <= N; i++) {
            tracks[1][i] = Integer.parseInt(t2[i - 1]);
        }
        int i = 1;
        while (i <= N) {
            if (i == 1 && tracks[0][1] == 0) {
                System.out.println("No");
                return;
            }
            if (i == N && tracks[0][i] == 0) {
                System.out.println("No");
                return;
            }
            if (i == M && tracks[0][i] == 1) {
                System.out.println("Yes");
                return;
            }
            if (i > M && tracks[0][i] == 1 &&  tracks[1][i] == 1)  {
                break;
            }

            if (i == N && tracks[0][i] != tracks[1][i]) {
                System.out.println("No");
                return;
            }
            i++;
        }
        while (i >= M) {
            if (i == M && tracks[1][i] == 0) {
                System.out.println("No");
                return;
            }
            if (i == M && tracks[1][i] == 1) {
                System.out.println("Yes");
                return;
            }
            i--;
        }
        System.out.println("No");
    }

    static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nc = br.readLine().split("\\s");
        int N = Integer.parseInt(nc[0]);
        int M = Integer.parseInt(nc[1]);

        int[][] tracks = new int[2][N + 1];
        String[] t1 = br.readLine().split("\\s");
        String[] t2 = br.readLine().split("\\s");
        for (int i = 1; i <= N; i++) {
            tracks[0][i] = Integer.parseInt(t1[i - 1]);
        }
        for (int i = 1; i <= N; i++) {
            tracks[1][i] = Integer.parseInt(t2[i - 1]);
        }
        if (tracks[0][1] == 1 && tracks[0][M] == 1) {
            System.out.println("Yes");
            return;
        }
        for (int i = M + 1; i<= N; i++) {
            if (tracks[0][1] == 1 && tracks[0][i] == 1 && tracks[1][i] == 1 && tracks[1][M] == 1) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
