package programmers;

public class 없는_숫자_더하기 {
    class Solution {
        public int solution(int[] numbers) {
            int[] cnts = new int[10];
            for (int num : numbers) {
                cnts[num]++;
            }


            int answer = 0;
            for (int i = 0; i < 10; i++) {
                if (cnts[i] == 0) {
                    answer += i;
                }
            }
            return answer;
        }
    }
}
