package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_2447 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        recursive(arr, n, 0, 0);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                bw.append(arr[r][c] == 1 ? '*' : ' ');
            }
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    static void recursive(int[][] arr, int n, int r, int c) {
        if (n == 3) {
            for (int cr = r; cr < r + 3; cr++) {
                for (int cc = c; cc < c + 3; cc++) {
                    arr[cr][cc] = 1;
                }
            }
            arr[r + 1][c + 1] = 0;
            return;
        }


        int k = n / 3;
        recursive(arr, k, r, c);
        recursive(arr, k, r, c + k);
        recursive(arr, k, r, c + 2 * k);

        recursive(arr, k, r + k, c);
//        recursive(arr, k, r + k, c + k);
        recursive(arr, k, r + k, c + 2 * k);

        recursive(arr, k, r + 2 * k, c);
        recursive(arr, k, r + 2 * k, c + k);
        recursive(arr, k, r + 2 * k, c + 2 * k);
    }
}
