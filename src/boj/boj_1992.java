package boj;

import java.io.*;

public class boj_1992 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr= new int[n][n];
        for (int r = 0; r < n; r++) {
            String input = br.readLine();
            for (int c = 0; c < n; c++) {
                arr[r][c] = input.charAt(c) - '0';
            }
        }
        
        recursive(bw, arr, n, 0, 0);

        bw.flush();
        bw.close();
        br.close();
    }
    
    static void recursive(BufferedWriter bw, int[][] arr, int n, int r, int c) throws IOException {
        int cnt = 0;
        for (int cr = r; cr < r + n; cr++) {
            for (int cc = c; cc < c + n; cc++) {
                cnt += arr[cr][cc];
            }
        }
        
        if (cnt == 0 || cnt == n * n) {
            bw.append(String.valueOf(cnt == 0 ? 0 : 1));
            return;
        }

        bw.append('(');
        recursive(bw, arr, n >> 1, r, c);
        recursive(bw, arr, n >> 1, r, c + (n >> 1));
        recursive(bw, arr, n >> 1, r + (n >> 1), c);
        recursive(bw, arr, n >> 1, r + (n >> 1), c + (n >> 1));
        bw.append(')');
    }
}
