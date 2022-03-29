package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_17086 {
    static final int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static final int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                int i = Integer.parseInt(st.nextToken());
                board[r][c] = i;
            }
        }

        int answer = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == 1) {
                    continue;
                }
                answer = Math.max(answer, bfs(n, m, board, r, c));
            }
        }
        System.out.println(answer);
        br.close();
    }

    static int bfs(int n, int m, int[][] board, int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(r, c));
        int[][] visited = new int[n][m];
        visited[r][c] = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (board[current.r][current.c] == 1) {
                return visited[current.r][current.c] - 1;
            }
            for (int i = 0; i < dr.length; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];
                if (nr < 0 || n <= nr || nc < 0 || m <= nc || visited[nr][nc] != 0) {
                    continue;
                }
                visited[nr][nc] = visited[current.r][current.c] + 1;
                queue.add(new Point(nr, nc));
            }
        }
        return -1;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
