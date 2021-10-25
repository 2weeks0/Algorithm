package programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class 구명보트 {

    class Solution {
        public int solution(int[] people, int limit) {
            Arrays.sort(people);
            LinkedList<Integer> deque = new LinkedList<>();
            for (int p : people) {
                deque.addLast(p);
            }

            int answer = 0;
            while (!deque.isEmpty()) {
                if (2 <= deque.size()) {
                    int min = deque.peekFirst();
                    int max = deque.peekLast();
                    if (min + max <= limit) {
                        answer++;
                        deque.pollFirst();
                        deque.pollLast();
                    } else {
                        answer++;
                        deque.pollLast();
                    }
                } else {
                    deque.pollFirst();
                    answer++;
                }
            }


            return answer;
        }
    }


}
