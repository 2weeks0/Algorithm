package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1316 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        outer: for (int i = 0; i < n; i++) {
            String word = br.readLine();
            boolean[] flag = new boolean[26];
            for (int j = 0; j < word.length(); j++) {
                int idx = word.charAt(j) - 'a';
                if (flag[idx] && word.charAt(j - 1) != word.charAt(j)) {
                    continue outer;
                }
                flag[idx] = true;
            }
            answer++;
        }

        System.out.println(answer);
        br.close();
    }
}
