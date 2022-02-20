package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_10162 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] buttons = {300, 60, 10};
        int[] cnt= new int[3];


        for (int i = 0; i < 3; i++) {
            cnt[i] = t / buttons[i];
            t %= buttons[i];
            if (t == 0) {
                break;
            }
        }

        if (t != 0) {
            System.out.println(-1);
            return;
        }

        final StringBuilder sb = new StringBuilder();
        Arrays.stream(cnt).forEach(i -> sb.append(i).append(' '));
        System.out.println(sb);
    }
}
