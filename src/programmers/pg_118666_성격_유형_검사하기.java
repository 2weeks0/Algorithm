package programmers;

public class pg_118666_성격_유형_검사하기 {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            String[] types = {"RT", "CF", "JM", "AN"};
            int[] answer = {0, 0, 0, 0};
            for (int i = 0; i < survey.length; i++) {
                String s = survey[i];
                int c = choices[i];

                for (int j = 0; j < types.length; j++) {
                    String t = types[j];
                    if (t.equals(s)) {
                        answer[j] += c - 4;
                        break;
                    } else if (t.charAt(0) == s.charAt(1)) {
                        answer[j] -= c - 4;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answer.length; i++) {
                int a = answer[i];
                String t = types[i];
                sb.append(0 < a ? t.charAt(1) : t.charAt(0));
            }

            return sb.toString();
        }
    }
}
