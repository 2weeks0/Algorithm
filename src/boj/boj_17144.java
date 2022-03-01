package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17144 {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, -1, 0, 1};

    static final int CLEANER = -1;
    static final int EMPTY = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] cleanerRows = {-1, -1};
        int[][] map = new int[r][c];
        for (int cr = 0; cr < r; cr++) {
            st = new StringTokenizer(br.readLine());
            for (int cc = 0; cc < c; cc++) {
                map[cr][cc] = Integer.parseInt(st.nextToken());
                if (map[cr][cc] == CLEANER) {
                    if (cleanerRows[0] == -1) {
                        cleanerRows[0] = cr;
                    } else {
                        cleanerRows[1] = cr;
                    }
                }
            }
        }

        for (int ct = 0; ct < t; ct++) {
            spread(r, c, map);
            cleanAir(r, c, map, cleanerRows);
        }

        printAnswer(r, c, map);
        br.close();
    }

    static void spread(int r, int c, int[][] map) {
        int[][] newMap = new int[r][c];
        for (int cr = 0; cr < r; cr++) {
            newMap[cr] = map[cr].clone();
        }

        for (int cr = 0; cr < r; cr++) {
            for (int cc = 0; cc < c; cc++) {
                if (map[cr][cc] <= 0) {
                    continue;
                }

                int dustSpread = map[cr][cc] / 5;
                for (int d = 0; d < 4; d++) {
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];
                    if (0 <= nr && nr < r && 0 <= nc && nc < c && map[nr][nc] != CLEANER) {
                        newMap[nr][nc] += dustSpread;
                        newMap[cr][cc] -= dustSpread;
                    }
                }
            }
        }

        for (int cr = 0; cr < r; cr++) {
            map[cr] = newMap[cr].clone();
        }
    }

    static void cleanAir(int r, int c, int[][] map, int[] cleanerRows) {
        int cr = cleanerRows[0] - 1;
        int cc = 0;

        while (cr != cleanerRows[0] || cc != 1) {
            if (cc == 0 && 0 <= cr - 1) {
                map[cr][cc] = map[--cr][cc];
            } else if (cr == 0 && cc + 1 < c) {
                map[cr][cc] = map[cr][++cc];
            } else if (cc == c - 1 && cr + 1 <= cleanerRows[0]) {
                map[cr][cc] = map[++cr][cc];
            } else if (cr == cleanerRows[0]) {
                map[cr][cc] = map[cr][--cc];
            }
        }

        map[cr][cc] = 0;
        cr = cleanerRows[1] + 1;
        cc = 0;

        while (cr != cleanerRows[1] || cc != 1) {
            if (cc == 0 && cr + 1 < r) {
                map[cr][cc] = map[++cr][cc];
            } else if (cr == r - 1 && cc + 1 < c) {
                map[cr][cc] = map[cr][++cc];
            } else if (cc == c - 1 && cleanerRows[1] <= cr - 1) {
                map[cr][cc] = map[--cr][cc];
            } else if (cr == cleanerRows[1]) {
                map[cr][cc] = map[cr][--cc];
            }
        }
        map[cr][cc] = 0;
    }

    static void printAnswer(int r, int c, int[][] map) {
        int answer = 0;
        for (int cr = 0; cr < r; cr++) {
            for (int cc = 0; cc < c; cc++) {
                if (0 < map[cr][cc]) {
                    answer += map[cr][cc];
                }
            }
        }
        System.out.println(answer);
    }
}
