package programmers;

import java.util.*;

public class pg_42628_이중우선순위큐 {
    class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> pqMin = new PriorityQueue<>();
            PriorityQueue<Integer> pqMax = new PriorityQueue<>((i1, i2) -> i2 - i1);

            for (String op : operations) {
                char ch = op.charAt(0);
                int num = Integer.valueOf(op.substring(2));
                if (ch == 'I') {
                    pqMin.add(num);
                    pqMax.add(num);
                } else if (num < 0 && 0 < pqMin.size()) {
                    int temp = pqMin.poll();
                    pqMax.remove(temp);
                } else if (0 < num && 0 < pqMax.size()) {
                    int temp = pqMax.poll();
                    pqMin.remove(temp);
                }
            }

            if (pqMin.size() == 0) {
                return new int[]{0, 0};
            } else {
                return new int[]{pqMax.poll(), pqMin.poll()};
            }
        }
    }
}
