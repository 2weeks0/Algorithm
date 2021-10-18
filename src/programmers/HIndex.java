package programmers;

import java.util.Arrays;

public class HIndex {
    static class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            int idx = 0;
            Arrays.sort(citations);
            for (int i = 0; i < citations.length; i++) {
                if (citations.length - i >= citations[i]) {
                    answer = citations[i];
                    idx = i;
                }
            }
            if (idx == citations.length - 1) {
                return answer;
            }

            for (int i = citations[idx] + 1; i < citations[idx + 1]; i++) {
                if (citations.length - idx - 1 >= i) {
                    answer = i;
                } else {
                    break;
                }
            }
            return answer;
        }
    }
}
