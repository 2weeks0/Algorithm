package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class boj_1937 {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                answer = Math.max(answer, dfs(n, board, visited, r, c, true));
                System.out.print(visited[r][c] + " ");
            }
            System.out.println();
        }

        System.out.println(answer);
        br.close();
    }

    static int dfs(int n, int[][] board, int[][] visited, int r, int c, boolean start) {
        if (visited[r][c] != -1) {
            return visited[r][c];
        }

        int cnt = 1;
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || n <= nr || nc < 0 || n <= nc || board[nr][nc] <= board[r][c]) {
                continue;
            }
            cnt = Math.max(cnt, dfs(n, board, visited, nr, nc, false) + 1);
        }
        visited[r][c] = cnt;
        return visited[r][c];
    }
}