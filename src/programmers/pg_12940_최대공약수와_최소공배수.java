package programmers;

public class pg_12940_최대공약수와_최소공배수 {
    class Solution {
        public int[] solution(int n, int m) {
            int gcd = gcd(n, m);
            return new int[]{gcd, n * m / gcd};
        }

        int gcd(int a, int b) {
            if (a < b) {
                return gcd(b, a);
            } else if (b == 0) {
                return a;
            } else {
                return gcd(b, a % b);
            }
        }
    }
}
