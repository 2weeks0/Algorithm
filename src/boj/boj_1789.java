package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1789 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long answer = 0;
        for (long i = 1; i * (i + 1) <= 2 * n; i++) {
            answer = i;
        }
        System.out.println(answer);
    }
}
