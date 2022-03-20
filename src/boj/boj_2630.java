package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2630 {
    static int cntWhite;
    static int cntBlue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(n, map, 0, 0);

        System.out.println(cntWhite);
        System.out.println(cntBlue);
        br.close();
    }

    static void recursive(int n, int[][] map, int r, int c) {
        int sum = 0;
        for (int cr = r; cr < r + n; cr++) {
            for (int cc = c; cc < c + n; cc++) {
                sum += map[cr][cc];
            }
        }
        if (sum == n * n) {
            cntBlue++;
            return;
        } else if (sum == 0) {
            cntWhite++;
            return;
        }

        recursive(n / 2, map, r, c);
        recursive(n / 2, map, r + n / 2, c);
        recursive(n / 2, map, r, c + n / 2);
        recursive(n / 2, map, r + n / 2, c + n / 2);
    }
}
