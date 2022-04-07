package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class swea_1249 {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];
            for (int r = 0; r < n; r++) {
                String line = br.readLine();
                for (int c = 0; c < n; c++) {
                    board[r][c] = line.charAt(c) - '0';
                }
            }
            int answer = dijkstra(n, board);

            bw.append(String.format("#%d %d\n", t, answer));
        }
        bw.close();
        br.close();
    }

    static int dijkstra(int n, int[][] board) {
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }
        visited[0][0] = board[0][0];
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> visited[p.r][p.c]));
        pq.add(new Point(0, 0));

        while (!pq.isEmpty()) {
            Point current = pq.poll();
            if (current.r == n - 1 && current.c == n - 1) {
                return visited[current.r][current.c];
            }
            for (int d = 0; d < dr.length; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 0 || n <= nr || nc < 0 || n <= nc || visited[nr][nc] != -1) {
                    continue;
                }
                visited[nr][nc] = visited[current.r][current.c] + board[nr][nc];
                pq.add(new Point(nr, nc));
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
