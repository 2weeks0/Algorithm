package programmers;

public class pg_60057_문자열_압축 {
    class Solution {
        public int solution(String s) {
            int answer = Integer.MAX_VALUE;
            for (int i = 1; i <= s.length(); i++) {
                int cnt = 0;
                int j;
                for (j = 0; j + i <= s.length(); j += i) {
                    int temp = 1;
                    String a = s.substring(j, j + i);
                    for (int k = j + i; k + i <= s.length(); k += i) {
                        String b = s.substring(k, k + i);
                        if (!a.equals(b)) {
                            break;
                        }
                        temp++;
                        j = k;
                    }
                    cnt += (temp != 1 ? String.valueOf(temp).length() : 0) + i;
                }
                cnt += s.length() - j;
                answer = Math.min(answer, cnt);
            }

            return answer;
        }
    }
}
