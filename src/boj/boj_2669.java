package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2669 {
    static final int MAX_SIZE = 100;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[4][4];
        for (int r = 0; r < 4; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 4; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] map = new int[MAX_SIZE + 1][MAX_SIZE + 1];
        for (int i = 0; i < 4; i++) {
            for (int r = arr[i][1]; r < arr[i][3]; r++) {
                for (int c = arr[i][0]; c < arr[i][2]; c++) {
                    map[r][c] = 1;
                }
            }
        }

        int answer = 0;
        for (int r = 0; r <= MAX_SIZE; r++) {
            for (int c = 0; c <= MAX_SIZE; c++) {
                if (map[r][c] == 1) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
