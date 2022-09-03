package programmers;

import java.util.Arrays;

public class pg_12915_문자열_내_마음대로_정렬하기 {
    class Solution {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, (a, b) -> {
                int diff = a.charAt(n) - b.charAt(n);
                if (diff == 0) {
                    return a.compareTo(b);
                }
                return diff;
            });
            return strings;
        }
    }
}
