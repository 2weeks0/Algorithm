package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_12904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder t = new StringBuilder(br.readLine());

        while (s.length() != t.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t.setLength(t.length() - 1);
            } else {
                t.setLength(t.length() - 1);
                t.reverse();
            }
        }

        System.out.println(s.equals(t.toString()) ? 1 : 0);
        br.close();
    }
}
