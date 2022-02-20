package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_5585 {
    static final int COST = 1000;
    static final int[] COINS = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = COST - Integer.parseInt(br.readLine());

        int answer = 0;
        int idx = 0;
        while (n != 0) {
            if (n < COINS[idx]) {
                idx++;
            } else {
                n -= COINS[idx];
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
