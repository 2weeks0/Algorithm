package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1799 {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(n, board, 0, new boolean[2 * n - 1], 0);

        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, int[][] board, int nr, boolean[] ncSelected, int cnt) {
        if (nr == 2 * n - 1) {
            answer = Math.max(answer, cnt);
            return;
        }

        boolean flag = false;
        for (int r = 0; r < n; r++) {
            int c = nr - r;
            if (c < 0 || n <= c || board[r][c] != 1) {
                continue;
            }
            int nc = c - r + n - 1;
            if (ncSelected[nc]) {
                continue;
            }
            flag = true;
            board[r][c] = 2;
            ncSelected[nc] = true;
            recursive(n, board, nr + 1, ncSelected, cnt + 1);
            ncSelected[nc] = false;
            board[r][c] = 1;
        }
        if (!flag) {
            recursive(n, board, nr + 1, ncSelected, cnt);
        }
    }
}
