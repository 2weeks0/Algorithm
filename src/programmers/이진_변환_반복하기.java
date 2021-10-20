package programmers;

import java.util.Arrays;

public class 이진_변환_반복하기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution("110010101001")));
    }

    static class Solution {
        public int[] solution(String s) {
            int[] answer = {0, 0};
            recursive(s, answer);
            return answer;
        }

        public void recursive(String s, int[] answer) {
            if (s.equals("1")) {
                return;
            }

            int numOfOne = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    numOfOne++;
                }
            }
            answer[0] += 1;
            answer[1] += s.length() - numOfOne;
            recursive(getBinary(numOfOne), answer);
        }

        public String getBinary(int n) {
            StringBuilder result = new StringBuilder();
            int endIdx = (int) (Math.log(n) / Math.log(2));
            for (int i = endIdx; i >= 0; i--) {
                int temp = (int) Math.pow(2, i);
                if (n >= temp) {
                    result.append(1);
                    n -= temp;
                } else {
                    result.append(0);
                }
            }
            return result.toString();
        }
    }


}
