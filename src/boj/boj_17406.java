package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17406 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] rotateInfos = new int[k][3];
        for (int r = 0; r < k; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 2; c++) {
                rotateInfos[r][c] = Integer.parseInt(st.nextToken()) - 1;
            }
            rotateInfos[r][2] = Integer.parseInt(st.nextToken());

        }

        permutation(k, 0, new int[k], map, rotateInfos, new boolean[k]);

        System.out.println(answer);
    }

    static void permutation(int k, int cnt, int[] arr, int[][] map, int[][] rotateInfos, boolean[] selected) {
        if (cnt == k) {
            int[][] temp = new int[map.length][];
            for (int r = 0; r < map.length; r++) {
                temp[r] = map[r].clone();
            }

            for (int i : arr) {
                int[] rotateInfo = rotateInfos[i];
                rotate(rotateInfo[0] - rotateInfo[2], rotateInfo[1] - rotateInfo[2], rotateInfo[0] + rotateInfo[2], rotateInfo[1] + rotateInfo[2], temp);
            }
            calculateMin(temp);
            return;
        }

        for (int i = 0; i < k; i++) {
            if (selected[i]) {
                continue;
            }
            int temp = arr[cnt];
            selected[i] = true;
            arr[cnt] = i;
            permutation(k, cnt + 1, arr, map, rotateInfos, selected);
            arr[cnt] = temp;
            selected[i] = false;
        }
    }

    static void rotate(int r1, int c1, int r2, int c2, int[][] temp) {
        int cnt = Math.min(r2 - r1 + 1, c2 - c1 + 1) / 2;
        for (int d = 0; d < cnt; d++) {
            int nr = r1 + d;
            int nc = c1 + d;
            int value = temp[nr][nc];
            do {
                if (nc == c1 + d && nr + 1 <= r2 - d) {
                    temp[nr][nc] = temp[++nr][nc];
                } else if (nr == r2 - d && nc + 1 <= c2 - d) {
                    temp[nr][nc] = temp[nr][++nc];
                } else if (nc == c2 - d &&  r1 + d <= nr - 1) {
                    temp[nr][nc] = temp[--nr][nc];
                } else {
                    temp[nr][nc] = temp[nr][--nc];
                }
            } while (!(nr == r1 + d && nc == c1 + d + 1));
            temp[nr][nc] = value;
        }


    }

    static void calculateMin(int[][] temp) {
        int sum;
        for (int[] arr : temp) {
            sum = 0;
            for (int num : arr) {
                sum += num;
            }
            answer = Math.min(answer, sum);
        }
    }
}
