package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576 {
    static final int RIPE = 1;
    static final int UNRIPE = 0;
    static final int EMPTY = -1;

    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][m];
        int[][] visited = new int[n][m];

        Queue<Point> queue = new ArrayDeque<>();
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                graph[r][c] = Integer.parseInt(st.nextToken());
                if (graph[r][c] == 1) {
                    queue.add(new Point(r, c));
                    visited[r][c] = 1;
                }
            }
        }

        bfs(n, m, graph, visited, queue);

        int answer = 0;
        outer: for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (graph[r][c] == UNRIPE) {
                    answer = -1;
                    break outer;
                } else if (graph[r][c] == RIPE) {
                    answer = Math.max(answer, visited[r][c] - 1);
                }
            }
        }
        System.out.println(answer);
        br.close();
    }

    static void bfs(int n, int m, int[][] graph, int[][] visited, Queue<Point> queue) {
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (0 <= nr && nr < n && 0 <= nc && nc < m && graph[nr][nc] != EMPTY && visited[nr][nc] == 0) {
                    graph[nr][nc] = RIPE;
                    visited[nr][nc] = visited[current.r][current.c] + 1;
                    queue.add(new Point(nr, nc));
                }
            }
        }
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
