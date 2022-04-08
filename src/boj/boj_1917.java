package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1917 {
    static final int WIDTH = 6;
    static final int HEIGHT = 6;
    static final int[] dr = {0, 0, 1, -1}; // 동 서 남 북
    static final int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        int[][] map = new int[3 * HEIGHT][WIDTH];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int r = 0; r < 3 * HEIGHT; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < WIDTH; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice();
        for (int i = 0; i < 3; i++) {
            dice.reset();
            bw.append(solve(map, 6 * i, dice) ? "yes" : "no").append('\n');
        }

        bw.close();
        br.close();
    }

    static boolean solve(int[][] map, int r, Dice dice) {
        for (int cr = r; cr < r + HEIGHT; cr++) {
            for (int cc = 0; cc < WIDTH; cc++) {
                if (map[cr][cc] == 0) {
                    continue;
                }
                recursive(map, r, r + 6, cr, cc, dice);
            }
        }
        return dice.success();
    }

    static void recursive(int[][] map, int minR, int maxR, int r, int c, Dice dice) {
        map[r][c] = 0;
        dice.setStatus(true);
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < minR || maxR <= nr || nc < 0 || WIDTH <= nc || map[nr][nc] == 0) {
                continue;
            }
            dice.roll(d);
            recursive(map, minR, maxR, nr, nc, dice);
            dice.roll((d & 1) == 0 ? d + 1 : d - 1);
        }
    }

    static class Dice {
        static final int IDX_BOT = 0;
        static final int IDX_LEFT = 1;
        static final int IDX_FRONT = 2;
        static final int IDX_RIGHT = 3;
        static final int IDX_BACK = 4;
        static final int IDX_TOP = 5;
        boolean[] area = new boolean[6];

        void reset() {
            Arrays.fill(area, false);
        }

        boolean success() {
            for (boolean b : area) {
                if (!b) {
                    return false;
                }
            }
            return true;
        }

        void setStatus(boolean value) {
            area[IDX_BOT] = value;
        }

        void roll(int d) {
            boolean temp;
            switch (d) {
                case 0:
                    temp = area[IDX_BOT];
                    area[IDX_BOT] = area[IDX_RIGHT];
                    area[IDX_RIGHT] = area[IDX_TOP];
                    area[IDX_TOP] = area[IDX_LEFT];
                    area[IDX_LEFT] = temp;
                    break;
                case 1:
                    temp = area[IDX_BOT];
                    area[IDX_BOT] = area[IDX_LEFT];
                    area[IDX_LEFT] = area[IDX_TOP];
                    area[IDX_TOP] = area[IDX_RIGHT];
                    area[IDX_RIGHT] = temp;
                    break;
                case 2:
                    temp = area[IDX_BOT];
                    area[IDX_BOT] = area[IDX_FRONT];
                    area[IDX_FRONT] = area[IDX_TOP];
                    area[IDX_TOP] = area[IDX_BACK];
                    area[IDX_BACK] = temp;
                    break;
                case 3:
                    temp = area[IDX_BOT];
                    area[IDX_BOT] = area[IDX_BACK];
                    area[IDX_BACK] = area[IDX_TOP];
                    area[IDX_TOP] = area[IDX_FRONT];
                    area[IDX_FRONT] = temp;
                    break;
            }
        }
    }
}
