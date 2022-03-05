package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17136 {
    static final int SIZE_MAP = 10;
    static final int CNT_PAPER = 5;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        int[] papers = new int[CNT_PAPER];
        for (int i = 0; i < CNT_PAPER; i++) {
            papers[i] = CNT_PAPER;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] map = new boolean[SIZE_MAP][SIZE_MAP];
        int area = 0;
        for (int r = 0; r < SIZE_MAP; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < SIZE_MAP; c++) {
                map[r][c] = Integer.parseInt(st.nextToken()) == 1;
                if (map[r][c]) {
                    area++;
                }
            }
        }

        recursive(papers, map, 0, 0, area);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        br.close();
    }

    static void recursive(int[] papers, boolean[][] map, int idx, int cnt, int area) {
        if (answer <= cnt) {
            return;
        } else if (idx == SIZE_MAP * SIZE_MAP) {
            if (area == 0) {
                answer = cnt;
            }
            return;
        }

        int r = idx / SIZE_MAP;
        int c = idx % SIZE_MAP;
        if (!map[r][c]) {
            recursive(papers, map, idx + 1, cnt, area);
            return;
        }

        int distance = 0;
        outer: for (int d = 4; 0 <= d; d--) {
            for (int cr = r; cr <= r + d; cr++) {
                for (int cc = c; cc <= c + d; cc++) {
                    if (SIZE_MAP <= cr || SIZE_MAP <= cc || !map[cr][cc]) {
                        continue outer;
                    }
                }
            }
            distance = d;
            break;
        }

        for (int d = distance; 0 <= d; d--) {
            if (papers[d] == 0) {
                continue;
            }
            setMap(map, r, c, d, false);
            papers[d]--;
            recursive(papers, map, idx + d + 1, cnt + 1, area - (d + 1) * (d + 1));
            setMap(map, r, c, d, true);
            papers[d]++;
        }
    }

    static void setMap(boolean[][] map, int r, int c, int d, boolean value) {
        for (int cr = r; cr <= r + d; cr++) {
            for (int cc = c; cc <= c + d; cc++) {
                map[cr][cc] = value;
            }
        }
    }
}
