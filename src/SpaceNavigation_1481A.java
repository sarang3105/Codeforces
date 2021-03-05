import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @link https://codeforces.com/contest/1481/problem/A
 */
public class SpaceNavigation_1481A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] cd = br.readLine().split("\\s");
            int x = Integer.parseInt(cd[0]);
            int y = Integer.parseInt(cd[1]);
            String directions = br.readLine();


            int r = 0, u = 0, d = 0, l = 0;
            for (int i = 0; i < directions.length(); i++) {
                char di = directions.charAt(i);
                if (di == 'R') {
                    r++;
                } else if (di == 'U') {
                    u++;
                } else if (di == 'D') {
                    d++;
                } else if (di == 'L') {
                    l++;
                }
            }

            if (x > 0 && r >= Math.abs(x)) x = 0;
            if (x < 0 && l >= Math.abs(x)) x = 0;
            if (y > 0 && u >= Math.abs(y)) y = 0;
            if (y < 0 && d >= Math.abs(y)) y = 0;

            if (x == 0 && y == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}