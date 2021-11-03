package programmers;

import java.util.PriorityQueue;

public class 더_맵게 {


    class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compareTo);
            for (int i : scoville) {
                pq.add(i);
            }

            int answer = 0;
            while (pq.size() >= 2 && pq.peek() < K) {
                int first = pq.poll();
                int second = pq.poll();
                int newOne = first + 2 * second;
                pq.add(newOne);
                answer++;
            }

            if (pq.stream().anyMatch((it -> it < K))) {
                return -1;
            } else {
                return answer;
            }
        }
    }


}
