package programmers;

public class n2_배열_자르기 {

    class Solution {
        public int[] solution(int n, long left, long right) {
            int[] answer = new int[(int)(right - left + 1)];
            for (int i = 0; i <= right - left; i++) {
                answer[i] = (int) Math.max((i + left) / n, (i + left) % n) + 1;
            }
            return answer;
        }
    }


}
