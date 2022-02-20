package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1987 {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};

    static int answer = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][];
        for (int cr = 0; cr < r; cr++) {
            map[cr] = br.readLine().toCharArray();
        }

        int[] visited = new int[26];
        visited[map[0][0] - 'A'] = 1;
        move(r, c, map, visited, 0, 0);

        System.out.println(answer);
        br.close();
    }

    static void move(int r, int c, char[][] map, int[] visited, int cr, int cc) {
        answer = Math.max(answer, visited[map[cr][cc] - 'A']);
        for (int d = 0; d < 4; d++) {
            int nr = cr + dr[d];
            int nc = cc + dc[d];
            if (0 <= nr && nr < r && 0 <= nc && nc < c && visited[map[nr][nc] - 'A'] == 0) {
                visited[map[nr][nc] - 'A'] = visited[map[cr][cc] - 'A'] + 1;
                move(r, c, map, visited, nr, nc);
                visited[map[nr][nc] - 'A'] = 0;
            }
        }

    }
}
