package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_2577 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n + k];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n; i < n + k; i++) {
            sushi[i] = sushi[i - n];
        }

        int[] eat = new int[d + 1];

        int answer = 0;
        int cnt = 0;
        int coupon = 0;
        for (int i = 0; i < n + k; i++) {
            if (k <= i) {
                int sushiNumDeleted = sushi[i - k];
                if (--eat[sushiNumDeleted] == 0) {
                    cnt--;
                }
                if (sushiNumDeleted == c) {
                    coupon--;
                }
            }
            int sushiNumAdded = sushi[i];
            if (++eat[sushiNumAdded] == 1) {
                cnt++;
            }
            if (sushiNumAdded == c) {
                coupon++;
            }
            answer = Math.max(answer , cnt + (coupon == 0 ? 1 : 0));
        }

        System.out.println(answer);
        br.close();
    }
}
