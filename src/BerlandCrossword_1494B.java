
import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @link
 */


public class BerlandCrossword_1494B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] in = br.readLine().split("\\s");
            int n = Integer.parseInt(in[0]);

            int[] pos = new int[4];
            for (int i = 1; i <= 4; i++) {
                pos[i - 1] = Integer.parseInt(in[i]);
            }

            boolean ans = false;
            for (int i = 0; i < 4; i++) {
                int u = pos[3];
                int r = pos[2];
                int d = pos[1];
                int l = pos[0];
                rotate(pos);
                if (u > 0 && r > 0) {
                    u -= 1;
                    r -= 1;
                }

                if (u > 0 && l > 0) {
                    u -= 1;
                    l -= 1;
                }

                if (d > 0 && l > 0) {
                    d -= 1;
                    l -= 1;
                }

                if (d > 0 && r > 0) {
                    d -= 1;
                    r -= 1;
                }

                if (u <= n - 2 && d <= n - 2 && r <= n - 2 && l <= n - 2) {
                    ans = true;
                    break;
                }
            }
            if(ans) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }

    public static void rotate(int[] a) {
        int t = a[a.length  - 1];
        for (int i = a.length - 1; i >= 1 ; i--) {
            a[i] = a[i - 1];
        }
        a[0] = t;
    }
}
