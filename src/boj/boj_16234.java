package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16234 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int cr = 0; cr < n; cr++) {
            st = new StringTokenizer(br.readLine());
            for (int cc = 0; cc < n; cc++) {
                map[cr][cc] = Integer.parseInt(st.nextToken());
            }
        }

        List<Point> list = new LinkedList<>();
        int t;
        for (t = 0; ; t++) {
            boolean flag = false;
            int[][] temp = new int[n][];
            for (int i = 0; i < n; i++) {
                temp[i] = map[i].clone();
            }

            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n * n; i++) {
                if (visited[i / n][i % n]) {
                    continue;
                }
                dfs(n, map, l, r, visited, i, list);
                if (list.size() == 1) {
                    list.clear();
                    continue;
                }
                flag = true;
                int sum = 0;
                for (Point point : list) {
                    sum += temp[point.r][point.c];
                }
                for (Point point : list) {
                    temp[point.r][point.c] = sum / list.size();
                }
                list.clear();
            }

            if (!flag) {
                break;
            }

            for (int cr = 0; cr < n; cr++) {
                for (int cc = 0; cc < n; cc++) {
                    map[cr][cc] = temp[cr][cc];
                }
            }
        }

        System.out.println(t);
        br.close();
    }

    static void dfs(int n, int[][] map, int l, int r, boolean[][] visited, int idx, List<Point> list) {
        int cr = idx / n;
        int cc = idx % n;
        visited[cr][cc] = true;
        list.add(new Point(cr, cc));

        for (int d = 0; d < 4; d++) {
            int nr = cr + dr[d];
            int nc = cc + dc[d];
            if (0 <= nr && nr < n && 0 <= nc && nc < n && !visited[nr][nc]) {
                int diff = Math.abs(map[cr][cc] - map[nr][nc]);
                if (l <= diff && diff <= r) {
                    dfs(n, map, l, r, visited, n * nr + nc, list);
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
