package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17070 {
    static final int HORIZON = 0;
    static final int VERTICAL = 1;
    static final int DIAGONAL = 2;

    static final int[][] dd = {
            {HORIZON, DIAGONAL},
            {VERTICAL, DIAGONAL},
            {HORIZON, VERTICAL, DIAGONAL},
    };

    static final int[][][] dr = {
            {{0}, {0, 1, 1}},
            {{1}, {0, 1, 1}},
            {{0}, {1}, {0, 1, 1}},
    };
    static final int[][][] dc = {
            {{1}, {1, 0, 1}},
            {{0}, {1, 0, 1}},
            {{1}, {0}, {1, 0, 1}},
    };

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken()) == 0;
            }
        }

        recursive(n, map, HORIZON, 0, 1);
        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, boolean[][] map, int direction, int r, int c) {
        if (r == n - 1 && c == n - 1) {
            answer++;
            return;
        }

        outer: for (int i = 0; i < dr[direction].length; i++) {
            int nr = 0;
            int nc = 0;
            for (int j = 0; j < dr[direction][i].length; j++) {
                nr = r + dr[direction][i][j];
                nc = c + dc[direction][i][j];
                if (nr < 0 || n <= nr || nc < 0 || n <= nc || !map[nr][nc]) {
                    continue outer;
                }
            }
            recursive(n, map, dd[direction][i], nr, nc);
        }
    }
}
