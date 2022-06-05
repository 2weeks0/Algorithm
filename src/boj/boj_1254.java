package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1254 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int i;
        outer: for (i = 0; i < str.length() - 1; i++) {
            for (int j = 0; i + j < str.length(); j++) {
                if (str.charAt(i + j) != str.charAt(str.length() - 1 - j)) {
                    continue outer;
                }
            }
            break;
        }

        System.out.println(str.length() + i);
        br.close();
    }
}
