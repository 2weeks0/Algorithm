package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2448 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2 * n - 1];
        recursive(n, 2 * n - 1, arr, n - 1, 0);

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                sb.append(arr[r][c] == 1 ? '*' : ' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    static void recursive(int n, int m, int[][] arr, int r, int c) {
        if (n == 3) {
            for (int i = 0; i < 5; i++) {
                arr[r][c + i] = 1;
            }
            arr[r - 1][c + 1] = 1;
            arr[r - 1][c + 3] = 1;
            arr[r - 2][c + 2] = 1;
            return;
        }

        int nextN = n >> 1;
        int nextM = m >> 1;
        recursive(nextN, nextM, arr, r, c);
        recursive(nextN, nextM, arr, r, c + nextM + 1);
        recursive(nextN, nextM, arr, r - nextN, c + (nextM >> 1) + 1);
    }
}