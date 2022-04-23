package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_1012 {
    static int answer = Integer.MAX_VALUE;
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] board = new int[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y][x] = 1;
            }

            boolean[][] visited = new boolean[n][m];
            int cnt = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (board[r][c] == 0 || visited[r][c]) {
                        continue;
                    }
                    cnt++;
                    recursive(n, m, board, visited, r, c);
                }
            }
            bw.append(String.valueOf(cnt)).append('\n');
        }
        bw.close();
        br.close();
    }

    static void recursive(int n, int m, int[][] board, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        for (int i = 0; i < dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || n <= nr || nc < 0 || m <= nc || board[nr][nc] == 0 || visited[nr][nc]) {
                continue;
            }
            recursive(n, m, board, visited, nr, nc);
        }
    }
}
