package programmers;

import java.util.Arrays;

public class pg_12935_제일_작은_수_제거하기 {
    class Solution {
        public int[] solution(int[] arr) {
            if (arr.length == 1) {
                return new int[]{-1};
            }

            boolean flag = true;
            int min = Arrays.stream(arr).min().getAsInt();
            int[] answer = new int[arr.length - 1];
            int idx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (flag && arr[i] == min) {
                    flag = false;
                    continue;
                }
                answer[idx++] = arr[i];
            }
            return answer;
        }
    }
}
