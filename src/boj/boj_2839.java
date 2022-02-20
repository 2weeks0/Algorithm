package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2839 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int cnt = 0;
        while (n % 5 != 0) {
            n -= 3;
            if (n < 0) {
                System.out.println(-1);
                return;
            }
            cnt++;
        }

        System.out.println(cnt + n / 5);
    }
}
