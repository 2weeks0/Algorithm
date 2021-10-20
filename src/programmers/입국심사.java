package programmers;

public class 입국심사 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(6, new int[]{7, 10}));
    }


    static class Solution {
        public long solution(int n, int[] times) {
            return bSearch(1, (long) 1e18, n, times);
        }

        public long bSearch(long left, long right, int n, int[] times) {
            if (left == right) {
                return left;
            }

            long mid = (left + right) / 2;
            long cnt = 0;
            for (int time : times) {
                cnt += mid / time;
            }

            if (cnt < n) {
                return bSearch(mid + 1, right, n, times);
            } else {
                return bSearch(left, mid, n, times);
            }
        }
    }


}
