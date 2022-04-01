package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1194 {
    static final char BLOCKED = '#';
    static final char START = '0';
    static final char DEST = '1';
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        Point start = null;
        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < m; c++) {
                board[r][c] = line.charAt(c);
                if (board[r][c] == START) {
                    start = new Point(r, c, 0);
                }
            }
        }

        System.out.println(bfs(n, m, board, start));
    }

    static int bfs(int n, int m, char[][] board, Point start) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(start);
        Map<Point, Integer> visited = new HashMap<>();
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int d = 0; d < dr.length; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 0 || n <= nr || nc < 0 || m <= nc) {
                    continue;
                }

                char ch = board[nr][nc];
                if (ch == DEST) {
                    return visited.get(current) + 1;
                } else if (ch != BLOCKED && !(Character.isUpperCase(ch) && (current.key & (int) Math.pow(2, (ch - 'A'))) == 0)) {
                    int nk = Character.isLowerCase(ch) ? current.key | (int) Math.pow(2, (ch - 'a')) : current.key;
                    Point next = new Point(nr, nc, nk);
                    if (visited.containsKey(next)) {
                        continue;
                    }
                    visited.put(next, visited.get(current) + 1);
                    queue.add(next);
                }
            }
        }

        return -1;
    }

    static class Point {
        int r;
        int c;
        int key;

        public Point(int r, int c, int key) {
            this.r = r;
            this.c = c;
            this.key = key;
        }

        @Override
        public int hashCode() {
            return 10000 * r + 100 * c + key;
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
