package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_2636 {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};

    static final int CHEESE = 1;
    static final int EMPTY =0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] tempBoard = new int[n][m];

        int t = 0;
        int cntMelt;
        int cntMeltLast = 0;
        do {
            t++;
            cntMelt = bfs(n, m, board, tempBoard, t);
            if (cntMelt != 0) {
                cntMeltLast = cntMelt;
            }
        } while (cntMelt != 0);

        System.out.println(t - 1);
        System.out.println(cntMeltLast);
        br.close();
    }

    static int bfs(int n, int m, int[][] board, int[][] tempBoard, int t) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int d = 0; d < dr.length; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 0 || n <= nr || nc < 0 || m <= nc || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                if (board[nr][nc] == CHEESE) {
                    tempBoard[nr][nc] = t;
                    continue;
                }
                queue.add(new Point(nr, nc));
            }
        }

        int result = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (tempBoard[r][c] == t) {
                    board[r][c] = EMPTY;
                    result++;
                }
            }
        }
        return result;
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
