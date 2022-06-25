package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_10988 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        boolean answer = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                answer = false;
                break;
            }
        }

        System.out.println(answer ? 1 : 0);
        br.close();
    }
}
