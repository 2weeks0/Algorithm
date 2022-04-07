package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1953 {
    static final int[][] dr = {
            null,
            {-1, 1, 0, 0},
            {-1, 1},
            {0, 0},
            {-1, 0},
            {1, 0},
            {1, 0},
            {-1, 0},
    };
    static final int[][] dc = {
            null,
            {0, 0, -1, 1},
            {0, 0},
            {-1, 1},
            {0, 1},
            {0, 1},
            {0, -1},
            {0, -1},
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[][] board = new int[n][m];
            for (int cr = 0; cr < n; cr++) {
                st = new StringTokenizer(br.readLine());
                for (int cc = 0; cc < m; cc++) {
                    board[cr][cc] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = bfs(n, m, board, r, c, l);
            bw.append(String.format("#%d %d\n", t, answer));
        }
        bw.close();
        br.close();
    }

    static int bfs(int n, int m, int[][] board, int r, int c, int l) {
        int result = 0;
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(r, c));
        int[][] visited = new int[n][m];
        visited[r][c] = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (visited[current.r][current.c] == l + 1) {
                return result;
            }
            result++;
            int type = board[current.r][current.c];
            for (int d = 0; d < dr[type].length; d++) {
                int nr = current.r + dr[type][d];
                int nc = current.c + dc[type][d];
                if (nr < 0 || n <= nr || nc < 0 || m <= nc
                        || board[nr][nc] == 0 || visited[nr][nc] != 0
                        || !passable(dr[type][d], dc[type][d], board[nr][nc])) {
                    continue;
                }
                visited[nr][nc] = visited[current.r][current.c] + 1;
                queue.add(new Point(nr, nc));
            }
        }

        return result;
    }

    static boolean passable(int ddr, int ddc, int nextType) {
        for (int d = 0; d < dr[nextType].length; d++) {
            if (-ddr == dr[nextType][d] && -ddc == dc[nextType][d]) {
                return true;
            }
        }
        return false;
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
