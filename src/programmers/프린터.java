package programmers;

import java.util.LinkedList;

public class 프린터 {

    class Solution {
        LinkedList<Docu> queue = new LinkedList<>();

        public int solution(int[] priorities, int location) throws Exception {
            init(priorities);
            return print(location);
        }

        public void init(int[] priorities) {
            for (int i = 0; i < priorities.length; i++) {
                queue.addLast(new Docu(priorities[i], i));
            }
        }

        public int print(int location) throws Exception {
            int result = 1;
            while (!queue.isEmpty()) {
                Docu docu = queue.pollFirst();
                assert docu != null;
                if (queue.stream().anyMatch(it -> docu.priority < it.priority)) {
                    queue.addLast(docu);
                } else if (docu.index == location) {
                    return result;
                } else {
                    result++;
                }
            }
            throw new Exception();
        }

        class Docu {
            final int priority;
            final int index;

            public Docu(int priority, int index) {
                this.priority = priority;
                this.index = index;
            }
        }
    }

}
