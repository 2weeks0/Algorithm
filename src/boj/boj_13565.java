package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13565 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];
        for (int r = 0; r < m; r++) {
            String s = br.readLine();
            for (int c = 0; c < n; c++) {
                board[r][c] = s.charAt(c) - '0';
            }
        }

        boolean[][] visited = new boolean[m][n];
        for (int c = 0; c < n; c++) {
            if (visited[0][c] || board[0][c] == 1) {
                continue;
            }
            dfs(m, n, board, visited, 0, c);
        }

        br.close();
        for (int c = 0; c < n; c++) {
            if (visited[m - 1][c]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    static void dfs(int m, int n, int[][] board, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || m <= nr || nc < 0 || n <= nc || visited[nr][nc] || board[nr][nc] == 1) {
                continue;
            }
            dfs(m, n, board, visited, nr, nc);
        }
    }
}
