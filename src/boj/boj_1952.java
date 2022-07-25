package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1952 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[r][c];
        System.out.println(recursive(r, c, board, 0, 0, 0, 0, 0) - 1);
        br.close();
    }

    static int recursive(int r, int c, boolean[][] board, int cr, int cc, int d, int cnt, int answer) {
        if (cnt == r * c) {
            return answer;
        }
        int nr = cr + dr[d];
        int nc = cc + dc[d];
        if (!board[cr][cc]) {
            board[cr][cc] = true;
            cnt++;
        }
        if (nr < 0 || r <= nr || nc < 0 || c <= nc || board[nr][nc]) {
            return recursive(r , c, board, cr, cc, (d + 1) % 4, cnt, answer + 1);
        } else {
            return recursive(r, c, board, nr, nc, d, cnt, answer);
        }
    }
}
