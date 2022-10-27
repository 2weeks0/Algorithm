package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2744 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('A' <= c && c <= 'Z') {
                sb.append((char) (c - 'A' + 'a'));
            } else {
                sb.append((char) (c - 'a' + 'A'));
            }
        }
        System.out.println(sb);
        br.close();
    }
}
