package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5656 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            answer = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int cntRemain = 0;
            int[][] board = new int[h][w];
            for (int r = 0; r < h; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < w; c++) {
                    int value = Integer.parseInt(st.nextToken());
                    board[r][c] = value;
                    if (0 < value) {
                        cntRemain++;
                    }
                }
            }

            recursive(n, w, h, board, cntRemain, 0);
            bw.append(String.format("#%d %d\n", t, answer));
        }
        bw.close();
        br.close();
    }

    static void recursive(int n, int w, int h, int[][] board, int cntRemain, int depth) {
        answer = Math.min(answer, cntRemain);
        if (depth == n) {
            return;
        }

        outer: for (int c = 0; c < w; c++) {
            for (int r = 0; r < h; r++) {
                if (0 < board[r][c]) {
                    int[][] tempBoard = cloneBoard(h, board);
                    int nCntRemain = boom(w, h, tempBoard, r, c, board[r][c]);
                    recursive(n, w, h, tempBoard, nCntRemain, depth + 1);
                    continue outer;
                }
            }
        }
    }

    static int[][] cloneBoard(int h, int[][] board) {
        int[][] result = new int[h][];
        for (int i = 0; i < h; i++) {
            result[i] = board[i].clone();
        }
        return result;
    }

    static int boom(int w, int h, int[][] board, int r, int c, int weight) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(r, c, weight));
        board[r][c] = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            outer: for (int d = 0; d < dr.length; d++) {
                int nr = point.r;
                int nc = point.c;
                for (int i = 0; i < point.weight - 1; i++) {
                    nr += dr[d];
                    nc += dc[d];
                    if (nr < 0 || h <= nr || nc < 0 || w <= nc) {
                        continue outer;
                    }

                    if (0 < board[nr][nc]) {
                        if (1 < board[nr][nc]) {
                            queue.add(new Point(nr, nc, board[nr][nc]));
                        }
                        board[nr][nc] = 0;
                    }
                }
            }
        }


        int result = 0;
        for (int cc = 0; cc < w; cc++) {
            for (int cr = h - 1; 0 <= cr; cr--) {
                if (board[cr][cc] != 0) {
                    queue.add(new Point(cr, cc, board[cr][cc]));
                    board[cr][cc] = 0;
                }
            }
            result += queue.size();
            int cr = h - 1;
            while (!queue.isEmpty()) {
                board[cr--][cc] = queue.poll().weight;
            }
        }

        return result;
    }

    static class Point {
        int r;
        int c;
        int weight;

        public Point(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }
    }
}
