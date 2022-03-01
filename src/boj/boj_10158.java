package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10158 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());
        br.close();

        int dx = 1;
        int dy = 1;

        for (int i = 0; i < t % (2 * w); i++) {
            if (p == 0 || p == w) {
                dx *= -1;
            }
            p += dx;
        }

        for (int i = 0; i < t % (2 * h); i++) {
            if (q == 0 || q == h) {
                dy *= -1;
            }
            q += dy;
        }

        System.out.printf("%d %d", p, q);
    }
}
