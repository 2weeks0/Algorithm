package programmers;

public class 큰_수_만들기 {


    class Solution {
        public String solution(String number, int k) {
            StringBuilder answer = new StringBuilder(number);
            for (int i = 0; i < answer.length() - 1; i++) {
                if (0 < k && answer.charAt(i) < answer.charAt(i + 1)) {
                    answer.deleteCharAt(i);
                    k--;
                }
            }
            return answer.substring(0, answer.length() - k);
        }
    }


}
