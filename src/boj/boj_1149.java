package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1149 {
    static final int R = 0;
    static final int G = 1;
    static final int B = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 3; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            arr[i][R] += Math.min(arr[i - 1][G], arr[i - 1][B]);
            arr[i][G] += Math.min(arr[i - 1][R], arr[i - 1][B]);
            arr[i][B] += Math.min(arr[i - 1][R], arr[i - 1][G]);
        }
        System.out.println(Arrays.stream(arr[n - 1]).min().getAsInt());
        br.close();
    }
}
