package programmers;

public class pg_12943_콜라츠_추측 {
    class Solution {
    public int solution(int num) {
        long temp = (long) num;
        int answer = 0;
        while (temp != 1 && answer <= 500) {
            if (temp % 2 == 0) {
                temp /= 2;
            } else {
                temp = temp * 3 + 1;
            }
            answer++;
        }
        return answer == 501 ? -1 : answer;
    }
}
}
