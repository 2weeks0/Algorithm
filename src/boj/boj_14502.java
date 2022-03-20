package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14502 {
    static final int SAFE = 0;
    static final int BLOCKED = 1;
    static final int VIRUS = 2;
    static final int COUNT = 3;
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        List<Point> virusList = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == VIRUS) {
                    virusList.add(new Point(r, c));
                }
            }
        }

        combination(n, m, map, virusList, new Point[COUNT], 0, 0);

        System.out.println(answer);
        br.close();
    }

    static void combination(int n, int m, int[][] map, List<Point> virusList, Point[] selected, int cnt, int idx) {
        if (cnt == COUNT) {
            boolean[][] visited = new boolean[n][m];
            virusList.forEach(it -> dfs(n, m, map, visited, it.r, it.c));

            int cntSafe = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (map[r][c] == SAFE && !visited[r][c]) {
                        cntSafe++;
                    }
                }
            }

            answer = Math.max(answer, cntSafe);
            return;
        }

        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (map[r][c] != SAFE) {
                continue;
            }
            map[r][c] = BLOCKED;
            selected[idx] = new Point(r, c);
            combination(n, m, map, virusList, selected, cnt + 1, idx + 1);
            map[r][c] = SAFE;
        }
    }

    static void dfs(int n, int m, int[][] map, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (0 <= nr && nr < n && 0 <= nc && nc < m && map[nr][nc] != BLOCKED && !visited[nr][nc]) {
                dfs(n, m, map, visited, nr, nc);
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
