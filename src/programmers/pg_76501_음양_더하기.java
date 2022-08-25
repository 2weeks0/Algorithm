package programmers;

public class pg_76501_음양_더하기 {
    class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
            for (int i = 0; i < absolutes.length; i++) {
                answer += signs[i] ? absolutes[i] : -absolutes[i];
            }
            return answer;
        }
    }
}
