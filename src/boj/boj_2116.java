package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2116 {
    static final int IDX_A = 0;
    static final int IDX_B = 1;
    static final int IDX_C = 2;
    static final int IDX_D = 3;
    static final int IDX_E = 4;
    static final int IDX_F = 5;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dices = new int[n][6];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 6; c++) {
                dices[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[] partnerIdx = {IDX_F, IDX_D, IDX_E, IDX_B, IDX_C, IDX_A};
        int max = 0;
        for (int i = 0; i < 6; i++) {
            int sum = 0;
            int dice = dices[0][i];

            for (int j = 0; j < n; j++) {
                int idx = i;
                for (int k = 0; k < 6; k++) {
                    if (j != 0 && dices[j][k] == dice) {
                        idx = k;
                        break;
                    }
                }

                int temp = 0;
                for (int k = 0; k < 6; k++) {
                    if (k == idx || k == partnerIdx[idx]) {
                        continue;
                    }
                    temp = Math.max(temp, dices[j][k]);
                }
                sum += temp;
                dice = dices[j][partnerIdx[idx]];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
        br.close();
    }
}
