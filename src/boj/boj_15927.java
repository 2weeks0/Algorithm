package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_15927 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        boolean useOneChar = true;

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                System.out.println(str.length());
                return;
            } else if (useOneChar && str.charAt(i) != str.charAt(i + 1)) {
                useOneChar = false;
            }
        }

        System.out.println(useOneChar ? -1 : str.length() - 1);
    }
}
