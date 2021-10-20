package programmers;

import java.util.Arrays;

public class 최댓값과_최솟값 {

    class Solution {
        public String solution(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            int[] nums = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            stringBuilder.append(String.format("%d %d", nums[0], nums[nums.length - 1]));
            return stringBuilder.toString();
        }
    }


}
