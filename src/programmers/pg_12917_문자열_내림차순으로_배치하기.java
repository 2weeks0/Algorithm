package programmers;

import java.util.Arrays;

public class pg_12917_문자열_내림차순으로_배치하기 {
    class Solution {
        public String solution(String s) {
            Character[] chars = new Character[s.length()];
            for (int i = 0; i < s.length(); i++) {
                chars[i] = s.charAt(i);
            }
            Arrays.sort(chars, (a, b) -> b - a);
            StringBuilder sb = new StringBuilder();
            for (Character ch : chars) {
                sb.append(ch);
            }
            return sb.toString();
        }
    }
}
