package programmers;

public class pg_12901_2016년 {
    class Solution {
        public String solution(int a, int b) {
            int cnt = 0;
            for (int i = 1; i <= a; i++) {
                if (i == a) {
                    cnt += b;
                } else {
                    switch (i) {
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                        case 12:
                            cnt += 31;
                            break;

                        case 2:
                            cnt += 29;
                            break;

                        default:
                            cnt += 30;
                            break;
                    }
                }
            }

            String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
            return days[(cnt - 1) % 7];
        }
    }
}
