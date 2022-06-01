package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1100 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        for (int r = 0; r < 8; r++) {
            String str = br.readLine();
            for (int c = 0; c < 8; c++) {
                if (str.charAt(c) == 'F' && ((r + c) & 1) == 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
