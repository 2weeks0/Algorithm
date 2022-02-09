package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_16968 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] cnt = {26, 10};
        int answer = cnt[input.charAt(0) - 'c'];

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if (input.charAt(i - 1) == current) {
                answer *= cnt[current - 'c'] - 1;
            } else {
                answer *= cnt[current - 'c'];
            }
        }

        System.out.println(answer);
    }
}
