package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1780 {
    static int[] cnt = new int[3];

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

        for (int i : cnt) {
            System.out.println(i);
        }
        br.close();
    }

    static void recursive(int n, int[][] map, int r, int c) {
        int temp = map[r][c];
        outer: for (int cr = r; cr < r + n; cr++) {
            for (int cc = c; cc < c + n; cc++) {
                if (map[cr][cc] != temp) {
                    temp = -2;
                    break outer;
                }
            }
        }

        if (temp == -1) {
            cnt[0]++;
            return;
        } else if (temp == 0) {
            cnt[1]++;
            return;
        } else if (temp == 1) {
            cnt[2]++;
            return;
        }

        recursive(n / 3, map, r, c);
        recursive(n / 3, map, r + n / 3, c);
        recursive(n / 3, map, r + 2 * n / 3, c);

        recursive(n / 3, map, r, c + n / 3);
        recursive(n / 3, map, r + n / 3, c + n / 3);
        recursive(n / 3, map, r + 2 * n / 3, c + n / 3);

        recursive(n / 3, map, r, c + 2 * n / 3);
        recursive(n / 3, map, r + n / 3, c + 2 * n / 3);
        recursive(n / 3, map, r + 2 * n / 3, c + 2 * n / 3);
    }
}
