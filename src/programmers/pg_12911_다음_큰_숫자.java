package programmers;

public class pg_12911_다음_큰_숫자 {
    class Solution {
        public int solution(int n) {
            String binary = Integer.toBinaryString(n);
            int cnt = 0;
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '1') {
                    cnt++;
                }
            }

            int answer;
            for (answer = n + 1; ; answer++) {
                String temp = Integer.toBinaryString(answer);
                int tempCnt = 0;
                for (int i = 0; i < temp.length(); i++) {
                    if (temp.charAt(i) == '1') {
                        tempCnt++;
                    }
                }
                if (tempCnt == cnt) {
                    break;
                }
            }
            return answer;
        }
    }
}
