package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1213 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        int[] cnt = new int[26];
        for (int i = 0; i < input.length(); i++) {
            cnt[input.charAt(i) - 'A']++;
        }

        int cntOdd = 0;
        int odd = -1;
        for (int i = 0; i < cnt.length; i++) {
            if ((cnt[i] & 1) == 1) {
                cntOdd++;
                odd = i;
            }
        }

        if (1 < cntOdd) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt.length; i++) {
            for (int j = 0; j < cnt[i] / 2; j++) {
                sb.append((char)('A' + i));
            }
        }
        if (odd != -1) {
            sb.append((char)('A' + odd));
        }

        for (int i = cnt.length - 1; 0 <= i; i--) {
            for (int j = 0; j < cnt[i] / 2; j++) {
                sb.append((char)('A' + i));
            }
        }

        System.out.println(sb);
    }
}
