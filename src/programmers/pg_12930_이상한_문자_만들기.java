package programmers;

public class pg_12930_이상한_문자_만들기 {
  class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                idx = -1;
                answer += c;
            } else if (idx % 2 == 0 && 'a' <= c && c <= 'z') {
                answer += (char) (c + 'A' - 'a');
            } else if (idx % 2 == 1 && 'A' <= c && c <= 'Z') {
                answer += (char) (c - ('A' - 'a'));
            } else {
                answer += c;
            }
            idx++;
        }
        return answer;
    }
}
}