package programmers;

import java.util.*;

public class pg_12923_숫자_블록 {

    class Solution {
        public int[] solution(long begin, long end) {
            int[] answer = new int[(int) (end - begin) + 1];
            Arrays.fill(answer, 1);
            if (begin == 1) {
                answer[0] = 0;
            }

            for (long i = begin; i <= end; i++) {
                for (int j = 2; j <= (int) Math.sqrt(i); j++) {
                    if (i % j == 0 && i / j <= 10_000_000) {
                        answer[(int) (i - begin)] = (int) (i / j);
                        break;
                    }
                }
            }

            return answer;
        }
    }
}