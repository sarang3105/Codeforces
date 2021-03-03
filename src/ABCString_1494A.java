

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @link
 */
public class ABCString_1494A {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String line = br.readLine();
            Map<Character, Character> s = new HashMap<>();
            s.put(line.charAt(0), '(');
            if (recur(line, new StringBuilder(), 0, s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean recur(String line, StringBuilder sb, int i, Map<Character, Character> s) {
        if (line.length() == sb.length() ) {
            if (isValid(sb.toString())) {
                return true;
            }
            return false;
        }
        if (s.containsKey(line.charAt(i))) {
            sb.append(s.get(line.charAt(i)));
            boolean d =  recur(line, sb, i + 1, s);
            sb.setLength(sb.length() - 1);
            return d;
        } else {
            s.put(line.charAt(i), '(');
            boolean r =  recur(line, sb.append('('), i + 1, s);
            sb.setLength(sb.length() - 1);
            s.remove(line.charAt(i));
            s.put(line.charAt(i), ')');
            boolean c = recur(line, sb.append(')'), i + 1, s);
            sb.setLength(sb.length() - 1);
            s.remove(line.charAt(i));
            return r || c;
        }
    }

    public static boolean isValid(String line) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(0) == line.charAt(i)) {
                st.add('(');
            } else if (st.isEmpty()){
               return false;
            } else {
                st.pop();
            }
        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;
    }
}
