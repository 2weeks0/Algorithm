package programmers;

import java.util.Arrays;

public class 징검다리 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(25, new int[]{2, 14, 11, 21, 17}, 1));
        System.out.println(new Solution().solution(25, new int[]{2, 14, 11, 21, 17}, 2));
        System.out.println(new Solution().solution(25, new int[]{2, 14, 11, 21, 17}, 5));
    }


    static class Solution {
        public int solution(int distance, int[] rocks, int n) {
            Arrays.sort(rocks);
            int[] diff = new int[rocks.length + 1];
            for (int i = 0; i < diff.length; i++) {
                if (i == 0) {
                    diff[i] = rocks[i];
                } else if (i == diff.length - 1) {
                    diff[i] = distance - rocks[rocks.length - 1];
                } else {
                    diff[i] = rocks[i] - rocks[i - 1];
                }
            }
            return binarySearch(1, distance + 1, diff, n) - 1;
        }

        public int binarySearch(int left, int right, int[] diff, int n) {
            System.out.printf("left: %d, right: %d, ", left, right);
            if (left == right) {
                return left;
            }

            int mid = (left + right) / 2;
            int cnt = 0;
            int temp = 0;
            for (int d : diff) {
                temp += d;
                if (temp < mid) {
                    cnt++;
                } else {
                    temp = 0;
                }
            }
            System.out.printf("mid: %d, cnt: %d\n", mid, cnt);

            if (n >= cnt) {
                return binarySearch(mid + 1, right, diff, n);
            } else {
                return binarySearch(left, mid, diff, n);
            }
        }
    }


}
