package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16967 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] a = new int[h][w];

        for (int r = 0; r < h + x; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < w + y; c++) {
                int num = Integer.parseInt(st.nextToken());
                if ((r < x && c < w) || (c < y && r < h)) {
                    a[r][c] = num;
                } else if ((h <= r && y <= c) || (w <= c && x <= r)) {
                    a[r - x][c - y] = num;
                } else if (x <= r && r < h - x && y <= c && c < w - y) {
                    a[r][c] = num - a[r - x][c - y];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                sb.append(a[r][c]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
