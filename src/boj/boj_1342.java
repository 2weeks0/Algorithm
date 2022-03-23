package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1342 {
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cnt = new int[26];
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            cnt[input.charAt(i) - 'a']++;
        }

        recursive(input.length(), cnt, -1, 0);

        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, int[] cnt, int idx, int depth) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0 || i == idx) {
                continue;
            }

            cnt[i]--;
            recursive(n, cnt, i, depth + 1);
            cnt[i]++;
        }
    }
}
