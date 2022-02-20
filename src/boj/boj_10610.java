package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_10610 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        int[] cnt = new int[10];
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            int value = n.charAt(i) - '0';
            sum += value;
            cnt[value]++;
        }

        if (cnt[0] == 0 || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; 0 <= i; i--) {
            for (int j = 0; j < cnt[i]; j++) {
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}
