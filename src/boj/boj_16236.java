package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16236 {
    static final int MAX_FISH_SIZE = 6;
    static final int SHARK = 9;
    static final int EMPTY = 0;

    static final int[] dr = {-1, 0, 0, 1};
    static final int[] dc = {0, -1, 1, 0};

    static int sizeShark = 2;
    static int cnt = 0;
    static int time = 0;

    static int cr = 0;
    static int cc = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int[] cntFish = new int[MAX_FISH_SIZE + 1];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == SHARK) {
                    cr = r;
                    cc = c;
                    map[r][c] = EMPTY;
                } else if (map[r][c] != EMPTY) {
                    cntFish[map[r][c]]++;
                }
            }
        }

        while (remainFishToEat(cntFish)) {
            if (!bfs(n, map, cntFish)) {
                break;
            }
        }

        System.out.println(time);
        br.close();
    }

    static boolean remainFishToEat(int[] cntFish) {
        int min = Math.min(MAX_FISH_SIZE + 1, sizeShark);
        for (int i = 1; i < min; i++) {
            if (cntFish[i] != 0) {
                return true;
            }
        }
        return false;
    }

    static boolean bfs(int n, int[][] map, int[] cntFish) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(cr, cc, 0));
        boolean[][] visited = new boolean[n][n];
        visited[cr][cc] = true;
        boolean flag = false;

        List<Point> list = new LinkedList<>();

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (map[current.r][current.c] != EMPTY && map[current.r][current.c] < sizeShark) {
                flag = true;
                list.add(current);
            }

            if (flag) {
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (isInRange(n, nr, nc) && map[nr][nc] <= sizeShark && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new Point(nr, nc, current.t + 1));
                }
            }
        }

        if (list.isEmpty()) {
            return false;
        }

        Collections.sort(list);
        eatFish(map, cntFish, list.get(0));
        return true;
    }

    static void eatFish(int[][] map, int[] cntFish, Point current) {
        cntFish[map[current.r][current.c]]--;
        map[current.r][current.c] = 0;
        time += current.t;
        cr = current.r;
        cc = current.c;
        if (++cnt == sizeShark) {
            sizeShark++;
            cnt = 0;
        }
    }

    static boolean isInRange(int n, int nr, int nc) {
        return 0 <= nr && nr < n && 0 <= nc && nc < n;
    }

    static class Point implements Comparable<Point> {
        int r;
        int c;
        int t;

        public Point(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }

        @Override
        public int compareTo(Point o) {
            if (t == o.t) {
                if (r == o.r) {
                    return Integer.compare(c, o.c);
                }
                return Integer.compare(r, o.r);
            }
            return Integer.compare(t, o.t);
        }
    }
}
