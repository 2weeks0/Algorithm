package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14686 {
    static final char WIN = 'A';
    static final char LOSE = 'B';
    static final char DRAW = 'D';

    static final int IDX_STAR = 4;
    static final int IDX_CIRCLE = 3;
    static final int IDX_SQUARE = 2;
    static final int IDX_TRIANGLE = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arrA = new int[5];
        int[] arrB = new int[5];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Arrays.fill(arrA, 0);
            Arrays.fill(arrB, 0);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                arrA[Integer.parseInt(st.nextToken())]++;
            }
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                arrB[Integer.parseInt(st.nextToken())]++;
            }

            bw.append(battle(arrA, arrB));
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    static char battle(int[] arrA, int[] arrB) {
        int result = 0;
        if (arrA[IDX_STAR] == arrB[IDX_STAR]) {
            if (arrA[IDX_CIRCLE] == arrB[IDX_CIRCLE]) {
                if (arrA[IDX_SQUARE] == arrB[IDX_SQUARE]) {
                    result = Integer.compare(arrA[IDX_TRIANGLE], arrB[IDX_TRIANGLE]);
                } else {
                    result = Integer.compare(arrA[IDX_SQUARE], arrB[IDX_SQUARE]);
                }
            } else {
                result = Integer.compare(arrA[IDX_CIRCLE], arrB[IDX_CIRCLE]);
            }
        } else {
            result = Integer.compare(arrA[IDX_STAR], arrB[IDX_STAR]);
        }

        if (result == 0) {
            return DRAW;
        } else if (result == 1) {
            return WIN;
        } else {
            return LOSE;
        }
    }
}
