package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_4485 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        int t = 1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int[][] board = new int[n][n];
            for (int r = 0; r < n; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++) {
                    board[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            bw.append(String.format("Problem %d: %d\n", t++, dijkstra(n, board)));
        }
        bw.close();
        br.close();
    }

    static int dijkstra(int n, int[][] board) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, board[0][0]));
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Point current = pq.poll();
            if (current.r == n - 1 && current.c == n - 1) {
                return current.d;
            }

            for (int d = 0; d < dr.length; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 0 || n <= nr || nc < 0 || n <= nc || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                pq.add(new Point(nr, nc, current.d + board[nr][nc]));
            }
        }

        return -1;
    }

    static class Point implements Comparable<Point> {
        int r;
        int c;
        int d;

        public Point(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(d, o.d);
        }
    }
}
