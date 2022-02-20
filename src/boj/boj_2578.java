package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2578 {
    static final int SIZE = 5;
    static final int CHECKED = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < SIZE; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[] nums = new int[SIZE * SIZE];
        for (int r = 0; r < SIZE; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < SIZE; c++) {
                nums[SIZE * r + c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < SIZE * SIZE; i++) {
            if (12 <= i && bingo(arr)) {
                System.out.println(i);
                return;
            }

            remove(arr, nums[i]);
        }
    }

    static boolean bingo(int[][] arr) {
        int result = 0;
        int cnt;
        for (int r = 0; r < SIZE; r++) {
            cnt = 0;
            for (int c = 0; c < SIZE; c++) {
                if (arr[r][c] == CHECKED) {
                    cnt++;
                }
            }
            if (cnt == SIZE) {
                result++;
            }
        }
        for (int c = 0; c < SIZE; c++) {
            cnt = 0;
            for (int r = 0; r < SIZE; r++) {
                if (arr[r][c] == CHECKED) {
                    cnt++;
                }
            }
            if (cnt == SIZE) {
                result++;
            }
        }
        cnt = 0;
        for (int i = 0; i < SIZE; i++) {
            if (arr[i][i] == CHECKED) {
                cnt++;
            }
        }
        if (cnt == SIZE) {
            result++;
        }
        cnt = 0;
        for (int i = 0; i < SIZE; i++) {
            if (arr[i][SIZE - 1 - i] == CHECKED) {
                cnt++;
            }
        }
        if (cnt == SIZE) {
            result++;
        }
        return result >= 3;
    }

    static void remove(int[][] arr, int num) {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (arr[r][c] == num) {
                    arr[r][c] = CHECKED;
                    return;
                }
            }
        }
    }
}
