package programmers;

import java.util.Arrays;

public class 두개_이하로_다른_비트 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new long[]{2, 7})));
    }

   static class Solution {
        public long[] solution(long[] numbers) {
            return Arrays.stream(numbers).map(this::function).toArray();
        }

        public long function(long number) {
            if (number % 2 == 0) {
                return number + 1;
            } else {
                String string = Long.toBinaryString(number);
                boolean find = false;
                for (int i = string.length() - 1; i >= 0; i--) {
                    if (string.charAt(i) == '0') {
                        find = true;
                        string = string.substring(0, i) + "10" + string.substring(i + 2);
                        break;
                    }
                }
                if (!find) {
                    string = "10" + string.substring(1);
                }
                return Long.parseLong(string, 2);
            }
        }
    }
}
