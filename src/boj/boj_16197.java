package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16197 {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        int[][] pos = new int[2][2];
        int idx = 0;
        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < m; c++) {
                map[r][c] = line.charAt(c);
                if (map[r][c] == 'o') {
                    pos[idx][0] = r;
                    pos[idx++][1] = c;
                }
            }
        }

        recursive(n, m, map, pos, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void recursive(int n, int m, char[][] map, int[][] pos, int cnt) {
        if (10 < cnt) {
            return;
        }

        int temp = 0;
        for (int[] p : pos) {
            if (p[0] < 0 || n <= p[0] || p[1] < 0 || m <= p[1]) {
                temp++;
            }
        }
        if (0 < temp) {
            if (temp == 1) {
                answer = Math.min(answer, cnt);
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int[][] tempPos = new int[2][2];
            for (int i = 0; i < pos.length; i++) {
                tempPos[i][0] = pos[i][0];
                tempPos[i][1] = pos[i][1];
                int nr = pos[i][0] + dr[d];
                int nc = pos[i][1] + dc[d];
                if (!(0 <= nr && nr < n && 0 <= nc && nc < m && map[nr][nc] == '#')) {
                    pos[i][0] = nr;
                    pos[i][1] = nc;
                }
            }
            recursive(n, m, map, pos, cnt + 1);
            for (int i = 0; i < pos.length; i++) {
                pos[i][0] = tempPos[i][0];
                pos[i][1] = tempPos[i][1];
            }
        }
    }
}
