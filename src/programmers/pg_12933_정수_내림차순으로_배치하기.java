package programmers;

import java.util.Arrays;

public class pg_12933_정수_내림차순으로_배치하기 {
    class Solution {
        public long solution(long n) {
            int length = String.valueOf(n).length();
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = (int) ((n / (long) Math.pow(10, i)) % 10);
            }
            Arrays.sort(arr);

            long answer = 0;
            for (int i = 0; i < length; i++) {
                answer += (long) Math.pow(10, i) * arr[i];
            }
            return answer;
        }
    }
}
