package programmers;

import java.util.LinkedList;

public class 주식가격 {

    class Solution {
        final LinkedList<Integer> queue = new LinkedList<>();

        public int[] solution(int[] prices) {
            init(prices);
            return getAnswer();
        }

        public void init(int[] prices) {
            for (int p : prices) {
                queue.addLast(p);
            }
        }

        public int[] getAnswer() {
            int[] result = new int[queue.size()];
            int idx = 0;
            while (!queue.isEmpty()) {
                int price = queue.pollFirst();
                int cnt = 0;
                for (int p: queue) {
                    cnt++;
                    if (price > p) {
                        break;
                    }
                }
                result[idx++] = cnt;
            }
            return result;
        }
    }


}
