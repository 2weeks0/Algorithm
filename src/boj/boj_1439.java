package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1439 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] cnt = {0, 0};
        char last = '2';
        for (int i = 0; i < input.length(); i++) {
            char c =  input.charAt(i);
            if (last != c) {
                cnt[c - '0']++;
            }
            last = c;
        }

        System.out.println(Arrays.stream(cnt).min().getAsInt());
        br.close();
    }
}
