package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea_5215 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Food[] foods = new Food[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                foods[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            int[] dp = new int[l + 1];
            for (Food food : foods) {
//                for (int i = 1; i <= l; i++) {
                for (int i = l; 1 <= i; i--) {
                    if (food.k <= i) {
                        dp[i] = Math.max(dp[i], dp[i - food.k] + food.t);
                    }
                }
            }

            bw.append('#').append(String.valueOf(t)).append(' ').append(String.valueOf(dp[l])).append('\n');
        }

        bw.close();
        br.close();
    }

    static class Food {
        int t;
        int k;

        public Food(int t, int k) {
            this.t = t;
            this.k = k;
        }
    }
}
