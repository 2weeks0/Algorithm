package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_12871 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        br.close();

        if (s.length() == t.length()) {
            System.out.println(s.equals(t) ? 1 : 0);
            return;
        }

        int l = s.length() * t.length();
        StringBuilder sbS = new StringBuilder();
        while (sbS.length() != l) {
            sbS.append(s);
        }
        StringBuilder sbT = new StringBuilder();
        while (sbT.length() != l) {
            sbT.append(t);
        }
        System.out.println(sbS.toString().equals(sbT.toString()) ? 1 : 0);
    }
}
