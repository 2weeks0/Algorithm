package programmers;

import java.util.LinkedList;

public class 예상_대진표 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(8, 4, 7));
    }

    static class Solution {
        public int solution(int n, int a, int b) {
            int answer = 0;

            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                queue.addLast(i);
            }

            while (!queue.isEmpty()) {
                int first = queue.pollFirst();
                assert !queue.isEmpty();
                int second = queue.pollFirst();
                if ((first == a && second == b) || (first == b && second == a)) {
                    return answer + 1;
                } else if (first == a || second == a) {
                    queue.addLast(a);
                    answer++;
                } else if (first == b || second == b) {
                    queue.addLast(b);
                } else {
                    queue.addLast(first);
                }
            }

            return answer;
        }
    }
}
