package programmers;

public class pg_12932_자연수_뒤집어_배열로_만들기 {
    class Solution {
        public int[] solution(long n) {
            int length = String.valueOf(n).length();
            int[] answer = new int[length];
            for (int i = 0; i < length; i++) {
                answer[i] = (int) ((n / (long) Math.pow(10, i)) % 10);
            }
            return answer;
        }
    }
}
