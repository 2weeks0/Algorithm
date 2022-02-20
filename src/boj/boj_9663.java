package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_9663 {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        backTracking(n, 0, new int[n]);
        System.out.println(answer);
        br.close();
    }

    static void backTracking(int n, int r, int[] col) {
        if (!isPossible(r - 1, col)) {
            return;
        } else if (n == r) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            col[r] = i;
            backTracking(n, r + 1, col);
        }
    }

    static boolean isPossible(int r, int[] col) {
        for (int i = 0; i < r; i++) {
            boolean isSameCol = col[i] == col[r];
            boolean isDiagonal = Math.abs(col[i] - col[r]) == Math.abs(i - r);
            if (isSameCol || isDiagonal) {
                return false;
            }
        }
        return true;
    }
}
