package programmers;

import java.util.HashSet;
import java.util.Set;

public class pg_1845_폰켓몬 {
    class Solution {
        public int solution(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            return Math.min(set.size(), nums.length / 2);
        }
    }
}
