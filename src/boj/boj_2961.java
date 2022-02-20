package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2961 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Food[] foods = new Food[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            foods[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i < Math.pow(2, n); i++) {
            int sumS = 1, sumB = 0;
            for (int j = 1; j <= i; j = j << 1) {
                if ((i & j) == j) {
                    int idx = (int) (Math.log(j) / Math.log(2));
                    sumS *= foods[idx].s;
                    sumB += foods[idx].b;
                }
            }
            answer = Math.min(answer, Math.abs(sumB - sumS));
        }

        System.out.println(answer);
    }

    static class Food {
        int s;
        int b;

        public Food(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }
}
