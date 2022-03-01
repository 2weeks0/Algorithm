package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10157 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        if (r * c < k) {
            System.out.println(0);
            return;
        }

        int[][] map = new int[r][c];
        int min = Math.min(r, c);
        int cnt = 0;
        int cr = -1;
        int cc = -1;
        for (int i = 0; i < (min + 1) / 2; i++) {
            cr += 1;
            cc += 1;
            while (map[cr][cc] == 0) {
                map[cr][cc] = ++cnt;
                if (cnt == k) {
                    System.out.printf("%d %d\n", cc + 1, cr + 1);
                    return;
                }
                if (cc == i && cr + 1 < r - i) {
                    cr++;
                } else if (cr == r - 1 - i && cc + 1 < c - i) {
                    cc++;
                } else if (cc == c - 1 - i && i <= cr - 1) {
                    cr--;
                } else if (cr == i && i <= cc - 1) {
                    cc--;
                }
            }
        }
    }
}
