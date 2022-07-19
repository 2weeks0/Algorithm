package boj;

import boj_14503.MapState;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2146 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};
    static int answer = Integer.MAX_VALUE;

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

        int value = 2;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 1) {
                    dfs(n, board, r, c, value++);
                }
            }
        }

        for (int i = 2; i < value; i++) {
            Queue<Point> queue = new ArrayDeque<>();
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (board[r][c] == i) {
                        queue.add(new Point(r, c));
                    }
                }
            }
            answer = Math.min(answer, bfs(n, board, queue, i));
        }


        System.out.println(answer);
        br.close();
    }

    static void dfs(int n, int[][] board, int r, int c, int value) {
        board[r][c] = value;
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || n <= nr || nc < 0 || n <= nc || board[nr][nc] != 1) {
                continue;
            }
            dfs(n, board, nr, nc, value);
        }
    }

    static int bfs(int n, int[][] board, Queue<Point> queue, int value) {
        int[][] dist = new int[n][n];

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (board[current.r][current.c] != 0 && board[current.r][current.c] != value && dist[current.r][current.c] != 0) {
                return dist[current.r][current.c] - 1;
            }

            for (int d = 0; d < dr.length; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 0 || n <= nr || nc < 0 || n <= nc || board[nr][nc] == value || dist[nr][nc] != 0) {
                    continue;
                }

                dist[nr][nc] = dist[current.r][current.c] + 1;
                queue.add(new Point(nr, nc));
            }
        }

        return Integer.MAX_VALUE;
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
