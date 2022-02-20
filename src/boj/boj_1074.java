package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1074 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(recursive((int) Math.pow(2, n), r, c));
    }

    static int recursive(int value, int r, int c) {
        if (value == 1) {
            return 0;
        }

        if (r < value / 2 && c < value / 2) {
            return recursive(value / 2, r, c);
        } else if (r < value / 2) {
            return value * value / 4 + recursive(value / 2, r, c - value / 2);
        } else if (c < value / 2) {
            return value * value / 2 + recursive(value / 2, r - value / 2, c);
        } else {
            return value * value / 4 * 3 + recursive(value / 2, r - value / 2, c - value / 2);
        }
    }
}
