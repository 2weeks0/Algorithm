package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_16926 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int cr = 0; cr < n; cr++) {
            st = new StringTokenizer(br.readLine());
            for (int cc = 0; cc < m; cc++) {
                arr[cr][cc] = Integer.parseInt(st.nextToken());
            }
        }

        for (int d = 0; d < Math.min(n, m) / 2; d++) {
            int cnt = 2 * (n - 2 * d) + 2 * (m - 2 * d - 2);
            for (int i = 0; i < r % cnt; i++) {
                rotate(n, m, arr, d);
            }
        }

        for (int cr = 0; cr < n; cr++) {
            for (int cc = 0; cc < m; cc++) {
                bw.append(String.valueOf(arr[cr][cc])).append(' ');
            }
            bw.newLine();
        }
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    static void rotate(int n, int m, int[][] arr, int depth) {
        int temp = arr[depth][depth];
        int nr = depth, nc = depth;
        do {
            if (nr == depth && nc + 1 <= m - 1 - depth) {
                arr[nr][nc] = arr[nr][++nc];
            } else if (nc == m - 1 - depth && nr + 1 <= n - 1 - depth) {
                arr[nr][nc] = arr[++nr][nc];
            } else if (nr == n - 1 - depth && depth <= nc - 1) {
                arr[nr][nc] = arr[nr][--nc];
            } else {
                arr[nr][nc] = arr[--nr][nc];
            }
        } while (!(nr == depth + 1 && nc == depth));
        arr[nr][nc] = temp;
    }
}
