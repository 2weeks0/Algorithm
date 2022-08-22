package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class pg_119667_두큐합_같게_만들기 {
    class Solution {
        public int solution(int[] queue1, int[] queue2) {
            long sum1 = 0;
            long sum2 = 0;
            Queue<Integer> q1 = new ArrayDeque<>();
            for (int i : queue1) {
                q1.add(i);
                sum1 += i;
            }
            Queue<Integer> q2 = new ArrayDeque<>();
            for (int i : queue2) {
                q2.add(i);
                sum2 += i;
            }

            int cnt = 0;
            while (sum1 != sum2) {
                if (cnt == 4 * queue1.length) {
                    return -1;
                }

                cnt++;
                if (sum1 < sum2) {
                    int temp = q2.poll();
                    q1.add(temp);
                    sum1 += temp;
                    sum2 -= temp;
                } else {
                    int temp = q1.poll();
                    q2.add(temp);
                    sum2 += temp;
                    sum1 -= temp;
                }
            }
            return cnt;
        }
    }

}
