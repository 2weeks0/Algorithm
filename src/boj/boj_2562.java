package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2562 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int idx = 0;
        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine());
            if (max < num) {
                max = num;
                idx = i;
            }
        }
        System.out.println(max);
        System.out.println(idx);
        br.close();
    }
}
