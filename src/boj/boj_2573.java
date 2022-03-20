package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2573 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int cnt;
        while (true) {
            answer++;
            melt(n, m, map);
            cnt = getCnt(n, m, map);
            if (cnt == -1) {
                answer = 0;
                break;
            } else if (2 <= cnt) {
                break;
            }
        }

        System.out.println(answer);
        br.close();
    }

    static void melt(int n, int m, int[][] map) {
        int[][] temp = new int[n][m];
        for (int r= 0;r <n;r++) {
            temp[r] = map[r].clone();
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (0 <= nr && nr < n && 0 <= nc && nc < m && temp[nr][nc] == 0) {
                        cnt++;
                    }
                }
                map[r][c] = Math.max(0, map[r][c] - cnt);
            }
        }
    }

    static int getCnt(int n, int m, int[][] map) {
        int result = 0;
        boolean[][] visited = new boolean[n][m];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] != 0 && !visited[r][c]) {
                    result++;
                    dfs(n, m, map, visited, r, c);
                }
            }
        }
        return result == 0 ? -1 : result;
    }

    static void dfs(int n, int m, int[][] map, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (0 <= nr && nr < n && 0 <= nc && nc < m && map[nr][nc] != 0 && !visited[nr][nc]) {
                dfs(n, m, map, visited, nr, nc);
            }
        }
    }
}
