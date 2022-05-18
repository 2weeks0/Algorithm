package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_11721 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if ((i + 1) % 10 == 0) {
                sb.append('\n');
            }
        }
        System.out.println(sb);
        br.close();
    }
}
