package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1600 {
    static final int BLOCKED = 1;
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static final int[] dr2 = {-1, -2, -2, -1, 1, 2, 2, 1};
    static final int[] dc2 = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] board = new int[h][w];
        for (int r = 0; r < h; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < w; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(k, w, h, board));
        br.close();
    }

    static int bfs(int k, int w, int h, int[][] board) {
        Point start = new Point(0, 0, 0);
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(start);
        Map<Point, Integer> visited = new HashMap<>();
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.r == h - 1 && current.c == w - 1) {
                return visited.get(current);
            }

            for (int d = 0; d < dr.length; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 0 || h <= nr || nc < 0 || w <= nc || board[nr][nc] == BLOCKED) {
                    continue;
                }
                Point next = new Point(current.k, nr, nc);
                if (visited.containsKey(next)) {
                    continue;
                }
                visited.put(next, visited.get(current) + 1);
                queue.add(next);
            }

            for (int d = 0; d < dr2.length; d++) {
                int nr = current.r + dr2[d];
                int nc = current.c + dc2[d];
                if (nr < 0 || h <= nr || nc < 0 || w <= nc || board[nr][nc] == BLOCKED || k == current.k) {
                    continue;
                }
                Point next = new Point(current.k + 1, nr, nc);
                if (visited.containsKey(next)) {
                    continue;
                }
                visited.put(next, visited.get(current) + 1);
                queue.add(next);
            }
        }

        return -1;
    }

    static class Point {
        int k;
        int r;
        int c;

        public Point(int k, int r, int c) {
            this.k = k;
            this.r = r;
            this.c = c;
        }

        @Override
        public int hashCode() {
            return k + 100 * r + 100000 * c;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) {
                return false;
            }
            return this.hashCode() == obj.hashCode();
        }
    }
}
