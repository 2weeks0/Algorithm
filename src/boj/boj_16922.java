package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_16922 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        br.close();

        for (int i = 1; i < n.length(); i++) {
            String left = n.substring(0, i);
            String right = n.substring(i);

            int mulLeft = 1;
            for (int j = 0; j < left.length(); j++) {
                mulLeft *= left.charAt(j) - '0';
            }
            int mulRight = 1;
            for (int j = 0; j < right.length(); j++) {
                mulRight *= right.charAt(j) - '0';
            }

            if (mulLeft == mulRight) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
