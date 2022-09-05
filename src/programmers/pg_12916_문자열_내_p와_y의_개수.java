package programmers;

public class pg_12916_문자열_내_p와_y의_개수 {
    class Solution {
        boolean solution(String s) {
            int pCnt = 0;
            int yCnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                    pCnt++;
                } else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                    yCnt++;
                }
            }
            return pCnt == yCnt;
        }
    }
}
