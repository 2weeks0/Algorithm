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

//            int answer = solveUsing2D(n, l, foods);
            int answer = solveUsing1D(l, foods);
            bw.append('#').append(String.valueOf(t)).append(' ').append(String.valueOf(answer)).append('\n');
        }

        bw.close();
        br.close();
    }

    static int solveUsing1D(int l, Food[] foods) {
        int[] dp = new int[l + 1];
        for (Food food : foods) {
            for (int i = l; food.k <= i; i--) {
                dp[i] = Math.max(dp[i], dp[i - food.k] + food.t);
            }
        }
        return dp[l];
    }

    static int solveUsing2D(int n, int l, Food[] foods) {
        int[][] dp = new int[n + 1][l + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                Food food = foods[i - 1];
                if (food.k <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - food.k] + food.t);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][l];
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
