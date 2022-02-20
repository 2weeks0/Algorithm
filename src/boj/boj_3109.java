package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3109 {
    static final int EMPTY = 0;
    static final int BLOCKED = 1;

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];
        for (int cr = 0; cr < r; cr++) {
            String input = br.readLine();
            for (int cc = 0; cc < c; cc++) {
                map[cr][cc] = input.charAt(cc) == '.' ? EMPTY : BLOCKED;
            }
        }

        for (int cr = 0; cr < r; cr++) {
            backTracking(map, r, c, cr, cr, 0);
        }

        System.out.println(answer);
        br.close();
    }

    static void backTracking(int[][] map, int r, int c, int sr, int cr, int cc) {
        if (cc + 1 == c) {
            map[sr][0] = BLOCKED; // 파이프 설치에 성공했다면 재귀를 종료시키기 위해 시작 지점을 BLOCKED 처리
            answer++;
            return;
        }

        for (int nr = cr - 1; nr <= cr + 1; nr++) {
            int nc = cc + 1;

            if (map[sr][0] == BLOCKED) { // 시작 지점에서 파생된 재귀를 종료시키기 위한 조건문
                return;
            } else if (nr < 0 || r <= nr || map[nr][nc] == BLOCKED) {
                continue;
            }

            map[nr][nc] = BLOCKED;
            backTracking(map, r, c, sr, nr, nc);
        }
    }
}
