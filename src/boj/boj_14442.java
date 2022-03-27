package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14442 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < m; c++) {
                board[r][c] = line.charAt(c) - '0';
            }
        }

        System.out.println(bfs(n, m, k, board));
        br.close();
    }

    static int bfs(int n, int m, int k, int[][] board) {
        int[][][] visited = new int[k + 1][n][m];
        visited[0][0][0] = 1;
        Queue<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 0, 0));

        while (!queue.isEmpty()) {
            Info current = queue.poll();
            if (current.r == n - 1 && current.c == m - 1) {
                return visited[current.k][current.r][current.c];
            }
            for (int d = 0; d < dr.length; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 0 || n <= nr || nc < 0 || m <= nc) {
                    continue;
                }
                if (board[nr][nc] == 0 && visited[current.k][nr][nc] == 0) {
                    visited[current.k][nr][nc] = visited[current.k][current.r][current.c] + 1;
                    queue.add(new Info(current.k, nr, nc));
                } else if (board[nr][nc] == 1 && current.k + 1 <= k && visited[current.k + 1][nr][nc] == 0) {
                    visited[current.k + 1][nr][nc] = visited[current.k][current.r][current.c] + 1;
                    queue.add(new Info(current.k + 1, nr, nc));
                }
            }
        }
        return -1;
    }

    static class Info {
        int k;
        int r;
        int c;

        public Info(int k, int r, int c) {
            this.k = k;
            this.r = r;
            this.c = c;
        }
    }
}
