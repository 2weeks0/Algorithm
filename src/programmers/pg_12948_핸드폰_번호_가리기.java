package programmers;

public class pg_12948_핸드폰_번호_가리기 {
    class Solution {
        public String solution(String phone_number) {
            String answer = "";
            for (int i = 0; i < phone_number.length() - 4; i++) {
                answer += "*";
            }
            answer += phone_number.substring(phone_number.length() - 4);
            return answer;
        }
    }
}
