package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15683 {
    static final int RIGHT = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int UP = 3;

    static final int EMPTY = 0;
    static final int BLOCKED = 6;

    static int cntTileWatched = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cntEmpty = 0;
        int[][] map = new int[n][m];
        List<CCTV> CCTVs = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == EMPTY) {
                    cntEmpty++;
                } else if (map[r][c] != BLOCKED) {
                    CCTVs.add(new CCTV(map[r][c], r, c));
                }
            }
        }

        recursive(n, m, map, new int[n][m], CCTVs, 0);

        System.out.println(cntEmpty - cntTileWatched);
        br.close();
    }

    static void recursive(int n, int m, int[][] map, int[][] cnt, List<CCTV> CCTVs, int idxCCTV) {
        if (idxCCTV == CCTVs.size()) {
            cntTileWatched = Math.max(cntTileWatched, countTileWatched(n, m, map, cnt));
            return;
        }

        CCTV target = CCTVs.get(idxCCTV);

        target.watch(n, m, map, cnt);
        recursive(n, m, map, cnt, CCTVs, idxCCTV + 1);

        while (target.canRotate()) {
            target.release(n, m, map, cnt);
            target.rotate();
            target.watch(n, m, map, cnt);
            recursive(n, m, map, cnt, CCTVs, idxCCTV + 1);
        }
        target.release(n, m, map, cnt);
        target.rotate();
    }

    static int countTileWatched(int n, int m, int[][] map, int[][] cnt) {
        int result = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] == EMPTY && 0 < cnt[r][c]) {
                    result++;
                }
            }
        }
        return result;
    }

    static class CCTV {
        static final int[] dr = {0, 1, 0, -1};
        static final int[] dc = {1, 0, -1, 0};

        int model;
        int r;
        int c;
        int direction;

        public CCTV(int model, int r, int c) {
            this.model = model;
            this.r = r;
            this.c = c;
            this.direction = RIGHT;
        }

        boolean canRotate() {
            switch (model) {
                case 1:
                case 3:
                case 4:
                    return (direction + 1) % 4 != RIGHT;
                case 2:
                    return (direction + 1) % 2 != RIGHT;
                case 5:
                default:
                    return false;
            }
        }

        void rotate() {
            switch (model) {
                case 1:
                case 3:
                case 4:
                    direction = (direction + 1) % 4;
                    break;
                case 2:
                    direction = (direction + 1) % 2;
                    break;
                case 5:
                    break;
            }
        }

        void release(int n, int m, int[][] map, int[][] cnt) {
            _search(n, m, map, cnt, false);
        }

        void watch(int n, int m, int[][] map, int[][] cnt) {
            _search(n, m, map, cnt, true);
        }

        void _search(int n, int m, int[][] map, int[][] cnt, boolean isWatchMode) {
            switch (model) {
                case 1:
                    _searchDirection(n, m, map, cnt, direction, isWatchMode);
                    break;
                case 2:
                    _searchDirection(n, m, map, cnt, direction, isWatchMode);
                    _searchDirection(n, m, map, cnt, (direction + 2) % 4, isWatchMode);
                    break;
                case 3:
                    _searchDirection(n, m, map, cnt, direction, isWatchMode);
                    _searchDirection(n, m, map, cnt, (direction + 1) % 4, isWatchMode);
                    break;
                case 4:
                    _searchDirection(n, m, map, cnt, direction, isWatchMode);
                    _searchDirection(n, m, map, cnt, (direction + 1) % 4, isWatchMode);
                    _searchDirection(n, m, map, cnt, (direction + 2) % 4, isWatchMode);
                    break;
                case 5:
                    _searchDirection(n, m, map, cnt, RIGHT, isWatchMode);
                    _searchDirection(n, m, map, cnt, DOWN, isWatchMode);
                    _searchDirection(n, m, map, cnt, LEFT, isWatchMode);
                    _searchDirection(n, m, map, cnt, UP, isWatchMode);
                    break;
            }
        }

        void _searchDirection(int n, int m, int[][] map, int[][] cnt, int direction, boolean isWatchMode) {
            int r = this.r + dr[direction];
            int c = this.c + dc[direction];
            while (0 <= r && r < n && 0 <= c && c < m && map[r][c] != BLOCKED) {
                cnt[r][c] += isWatchMode ? 1 : -1;
                r += dr[direction];
                c += dc[direction];
            }
        }
    }
}
