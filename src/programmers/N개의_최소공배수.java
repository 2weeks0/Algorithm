package programmers;

public class N개의_최소공배수 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{2, 6, 8, 14}));
    }

    static class Solution {
        public int solution(int[] arr) {
            int lgm = arr[0];
            for (int n : arr) {
                lgm = lgm(lgm, n);
            }
            return lgm;
        }

        public int lgm(int a, int b) {
            return a * b / gcd(a, b);
        }

        public int gcd(int a, int b) {
            if (a < b) {
                return gcd(b, a);
            }

            if (b == 0) {
                return a;
            } else {
                return gcd(b, a % b);
            }
        }

    }


}
