package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2563 {
    static final int SIZE_BACKGROUND = 100;
    static final int SIZE_PAPER = 10;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] map = new boolean[SIZE_BACKGROUND][SIZE_BACKGROUND];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int cr = r; cr < r + SIZE_PAPER; cr++) {
                for (int cc = c; cc < c + SIZE_PAPER; cc++) {
                    map[cr][cc] = true;
                }
            }
        }

        int answer = 0;
        for (int r = 0; r < SIZE_BACKGROUND; r++) {
            for (int c = 0; c < SIZE_BACKGROUND; c++) {
                if (map[r][c]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
