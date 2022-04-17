package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_16991 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        double[][] dp = new double[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Double.MAX_VALUE);
        }

        System.out.printf("%.6f\n", recursive(n, points, dp, 0, 1));
        br.close();
    }

    static double recursive(int n, Point[] points, double[][] dp, int current, int bit) {
        if (bit == (1 << n) - 1) {
            return points[current].distanceTo(points[0]);
        } else if (dp[current][bit] != Double.MAX_VALUE) {
            return dp[current][bit];
        }

        for (int i = 0; i < n; i++) {
            if ((bit & (1 << i)) != 0) {
                continue;
            }
            dp[current][bit] = Math.min(dp[current][bit], points[current].distanceTo(points[i]) + recursive(n, points, dp, i, bit | (1 << i)));
        }
        return dp[current][bit];
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        double distanceTo(Point point) {
            int diffX = x - point.x;
            int diffY = y - point.y;
            return Math.sqrt(diffX * diffX + diffY * diffY);
        }
    }
}
