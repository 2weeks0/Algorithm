package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {


    class Solution {
        int[][] omr = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        public int[] solution(int[] answers) {
            int[] cnts = {0, 0, 0};
            for (int i = 0; i < answers.length; i++) {
                for (int j = 0; j < 3; j++) {
                    cnts[j] += omr[j][i % omr[j].length] == answers[i] ? 1 : 0;
                }
            }
            int max = Arrays.stream(cnts).max().getAsInt();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < cnts.length; i++) {
                if (cnts[i] == max) {
                    result.add(i);
                }
            }
            return result.stream().mapToInt(i -> i).toArray();
        }


    }


}
