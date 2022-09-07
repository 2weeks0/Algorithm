package programmers;

import java.util.Arrays;

public class pg_12944_평균_구하기 {
    class Solution {
        public double solution(int[] arr) {
            return (double) Arrays.stream(arr).sum() / arr.length;
        }
    }
}
