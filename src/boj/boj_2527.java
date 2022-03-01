package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2527 {
    static final int TC = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rec1 = new int[4];
        int[] rec2 = new int[4];
        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                rec1[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < 4; i++) {
                rec2[i] = Integer.parseInt(st.nextToken());
            }
            double cx1 = ((double)rec1[0] + rec1[2]) / 2;
            double cy1 = ((double)rec1[1] + rec1[3]) / 2;
            double cx2 = ((double)rec2[0] + rec2[2]) / 2;
            double cy2 = ((double)rec2[1] + rec2[3]) / 2;

            double diffCx = Math.abs(cx1- cx2);
            double diffCy = Math.abs(cy1- cy2);

            int sumXLine = rec1[2] - rec1[0] + rec2[2] - rec2[0];
            int sumYLine = rec1[3] - rec1[1] + rec2[3] - rec2[1];

            if (sumXLine == 2 * diffCx && sumYLine == 2 * diffCy) {
                System.out.println('c');
            } else if (sumXLine < 2 * diffCx || sumYLine < 2 * diffCy) {
                System.out.println('d');
            } else if (sumXLine == 2 * diffCx || sumYLine == 2 * diffCy) {
                System.out.println('b');
            } else {
                System.out.println('a');
            }
        }
        br.close();
    }
}
