package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18111 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[][] map = new int[m][n];
        for (int r = 0; r < m; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[r][c]);
                max = Math.max(max, map[r][c]);
            }
        }

        int[] answer = {Integer.MAX_VALUE, 0};
        for (int h = max; h >= min; h--) {
            int t = 0;
            int inventory = 0;
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (h < map[r][c]) {
                        inventory += map[r][c] - h;
                        t += 2 * (map[r][c] - h);
                    } else if (map[r][c] < h) {
                        inventory -= h - map[r][c];
                        t += h - map[r][c];
                    }
                }
            }

            if (0 <= b + inventory && t < answer[0]) {
                answer[0] = t;
                answer[1] = h;
            }
        }

        System.out.printf("%d %d\n", answer[0], answer[1]);
    }
}
