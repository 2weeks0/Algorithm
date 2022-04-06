package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2239 {
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];
        for (int r = 0; r < 9; r++) {
            String line = br.readLine();
            for (int c = 0; c < 9; c++) {
                arr[r][c] = line.charAt(c) - '0';
            }
        }

        recursive(arr, 0);
        br.close();
    }

    static void recursive(int[][] arr, int idx) {
        if (flag) {
            return;
        } else if (idx == 9 * 9) {
            flag = true;
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    System.out.print(arr[r][c]);
                }
                System.out.println();
            }
            return;
        }

        int r = idx / 9;
        int c = idx % 9;
        if (arr[r][c] != 0) {
            recursive(arr, idx + 1);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            arr[r][c] = i;
            if (possible(arr, r, c, i)) {
                recursive(arr, idx + 1);
                arr[r][c] = 0;
            }
        }
    }

    static boolean possible(int[][] arr, int r, int c, int value) {
        for (int i = 0; i < 9; i++) {
            if (i != r && arr[i][c] == value) {
                return false;
            } else if (i != c && arr[r][i] == value) {
                return false;
            }
        }
        int sr = r / 3 * 3;
        int sc = c / 3 * 3;
        for (int cr = sr; cr < sr + 3; cr++) {
            for (int cc = sc; cc < sc + 3; cc++) {
                if (cr != r && cc != c && arr[cr][cc] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
