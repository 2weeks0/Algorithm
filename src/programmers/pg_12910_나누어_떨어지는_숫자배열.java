package programmers;

import java.util.HashSet;
import java.util.Set;

public class pg_12910_나누어_떨어지는_숫자배열 {
    class Solution {
        public int[] solution(int[] arr, int divisor) {
            Set<Integer> set = new HashSet<>();
            for (int i : arr) {
                if (i % divisor == 0) {
                    set.add(i);
                }
            }
            if (set.isEmpty()) {
                set.add(-1);
            }
            return set.stream().mapToInt(it -> it).sorted().toArray();
        }
    }
}
