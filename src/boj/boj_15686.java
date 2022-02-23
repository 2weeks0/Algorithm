package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15686 {
    static final int MAX_SIZE_BHC = 13;
    static final int EMPTY = 0;
    static final int HOUSE = 1;
    static final int BHC = 2;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Point> bhcList = new ArrayList<>(MAX_SIZE_BHC);
        List<Point> houseList = new ArrayList<>(2 * n);
        int[][] map = new int[n][n];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == BHC) {
                    bhcList.add(new Point(r, c));
                } else if (map[r][c] == HOUSE) {
                    houseList.add(new Point(r, c));
                }
            }
        }

        combination(m, map, bhcList, new Point[m], 0, 0, houseList);

        System.out.println(answer);
        br.close();
    }

    static void combination(int m, int[][] map, List<Point> bhcList, Point[] sel, int cnt, int idx, List<Point> houseList) {
        if (cnt == m) {
            answer = Math.min(answer, getMinDistance(houseList, sel));
            return;
        }

        for (int i = idx; i < bhcList.size(); i++) {
            sel[cnt] = bhcList.get(i);
            combination(m, map, bhcList, sel, cnt + 1, i + 1, houseList);
        }
    }

    static int getMinDistance(List<Point> houseList, Point[] sel) {
        int result = 0;
        for (Point house : houseList) {
            int min = Integer.MAX_VALUE;
            for (Point bhc : sel) {
                min = Math.min(min, Math.abs(house.r - bhc.r) + Math.abs(house.c - bhc.c));
            }
            result += min;
        }
        return result;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
