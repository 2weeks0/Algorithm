package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14716 {
    static final int[] dr = {0, 1, 0, -1, 1, 1, -1, -1};
    static final int[] dc = {1, 0, -1, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[m][n];
        for (int r = 0; r < m; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        boolean[][] visited = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (visited[r][c] || map[r][c] == 0) {
                    continue;
                }
                dfs(m, n, map, visited, r, c);
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }

    static void dfs(int m, int n, int[][] map, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        for (int i = 0; i < dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || m <= nr || nc < 0 || n <= nc || map[nr][nc] == 0 || visited[nr][nc]) {
                continue;
            }
            dfs(m, n, map, visited, nr, nc);
        }
    }
}
