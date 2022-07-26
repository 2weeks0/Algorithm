package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_19238 {
    static final int[] dr = {-1, 0, 0, 1};
    static final int[] dc = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int o = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int cr = Integer.parseInt(st.nextToken()) - 1;
        int cc = Integer.parseInt(st.nextToken()) - 1;

        Point[] destinations = new Point[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            board[r1][c1] = 2 + i;
            destinations[i] = new Point(r2, c2);
        }

        int type = 0;
        int cnt = 0;
        while (true) {
            Info info = bfs(n, board, destinations, cr, cc, type);
            if (info == null) {
                break;
            }

            o -= info.dist;
            if (o < 0) {
                break;
            }

            if (type != 0) {
                o += 2 * info.dist;
            }
            type = info.type;
            cr = info.cr;
            cc = info.cc;
            cnt++;
        }

        System.out.println(cnt == 2 * m ? o : -1);
        br.close();
    }

    static Info bfs(int n, int[][] board, Point[] destinations, int cr, int cc, int type) {
        int[][] visited = new int[n][n];
        visited[cr][cc] = 1;
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(cr, cc));

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> {
            if (visited[a.r][a.c] == visited[b.r][b.c]) {
                if (a.r == b.r) {
                    return Integer.compare(a.c, b.c);
                }
                return Integer.compare(a.r, b.r);
            }
            return Integer.compare(visited[a.r][a.c], visited[b.r][b.c]);
        });

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if ((type == 0 && 1 < board[current.r][current.c]) || (type != 0 && destinations[type - 2].equals(current))) {
                pq.add(current);
            }

            for (int d = 0; d < dr.length; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 0 || n <= nr || nc < 0 || n <= nc || visited[nr][nc] != 0 || board[nr][nc] == 1) {
                    continue;
                }

                visited[nr][nc] = visited[current.r][current.c] + 1;
                queue.add(new Point(nr, nc));
            }
        }

        if (pq.isEmpty()) {
            return null;
        } else {
            Point point = pq.poll();
            int newType = 0;
            if (type == 0) {
                newType = board[point.r][point.c];
                board[point.r][point.c] = 0;
            }

            return new Info(newType, visited[point.r][point.c] - 1, point.r, point.c);
        }
    }

    static class Info {
        int type;
        int dist;
        int cr;
        int cc;

        public Info(int type, int dist, int cr, int cc) {
            this.type = type;
            this.dist = dist;
            this.cr = cr;
            this.cc = cc;
        }
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) {
                return false;
            }
            return r == ((Point) obj).r && c == ((Point) obj).c;
        }
    }
}
