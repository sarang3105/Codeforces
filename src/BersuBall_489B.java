import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @link https://codeforces.com/problemset/problem/489/B
 */
public class BersuBall_489B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] boys = new int[n];
        String[] line = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            boys[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(boys);

        int m = Integer.parseInt(br.readLine());
        line = br.readLine().split("\\s");
        int[] girls = new int[m];
        for (int i = 0; i < m; i++) {
            girls[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(girls);

        int count = 0;
        int i = 0, j = 0;
        while (i < n && j < m) {
            int diff = girls[j] - boys[i];
            if (diff == 0 || diff == 1 || diff == -1) {
                count++;
                i++;
                j++;
            } else if (diff > 1) {
                i++;
            } else if (diff < -1) {
                j++;
            }
        }
        System.out.println(count);
    }
}
