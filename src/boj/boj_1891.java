package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1891 {
    static Stack<Integer> stack = new Stack<>();
    static long r, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken()); // 1 <= d <= 50
        String str = st.nextToken(); // 사분면의 번호 341

        st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken()); // |x, y| <= 2^50
        long y = Long.parseLong(st.nextToken());

        findPosition(d, str, 0, 0, 0);

        long k = (long) Math.pow(2, d);
        r -= y;
        c += x;
        if (r < 0 || k <= r || c < 0 || k <= c) {
            System.out.println(-1);
            return;
        }
        parse(d, 0, r, c);

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
        br.close();
    }

    static void findPosition(int d, String str, int depth, long cr, long cc) {
        if (depth == d) {
            r = cr;
            c = cc;
            return;
        }

        int temp = str.charAt(depth) - '0';
        if (temp == 1) {
            findPosition(d, str, depth + 1, 2 * cr, 2 * cc + 1);
        } else if (temp == 2) {
            findPosition(d, str, depth + 1, 2 * cr, 2 * cc);
        } else if (temp == 3) {
            findPosition(d, str, depth + 1, 2 * cr + 1, 2 * cc);
        } else {
            findPosition(d, str, depth + 1, 2 * cr + 1, 2 * cc + 1);
        }
    }

    static void parse(int n, int depth, long cr, long cc) {
        if (depth == n) {
            return;
        }


        if (cr % 2 == 0 && cc % 2 == 1) {
            stack.push(1);
        } else if (cr % 2 == 0 && cc % 2 == 0) {
            stack.push(2);
        } else if (cr % 2 == 1 && cc % 2 == 0) {
            stack.push(3);
        } else {
            stack.push(4);
        }
        parse(n, depth + 1, cr / 2, cc / 2);
    }
}
