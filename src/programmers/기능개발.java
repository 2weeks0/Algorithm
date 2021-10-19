package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 기능개발 {


    class Solution {
        final LinkedList<Function> stack = new LinkedList<>();

        public int[] solution(int[] progresses, int[] speeds) {
            init(progresses, speeds);
            return getAnswer();
        }

        public void init(int[] progresses, int[] speeds) {
            for (int i = progresses.length - 1; i >= 0; i--) {
                stack.addLast(new Function(progresses[i], speeds[i]));
            }
        }

        public int[] getAnswer() {
            List<Integer> result = new ArrayList<>();
            while (!stack.isEmpty()) {
                stack.forEach(Function::proceed);
                int cnt = 0;
                while (!stack.isEmpty() && stack.peekLast().isCompleted()) {
                    cnt++;
                    stack.pollLast();
                }
                if (cnt != 0) {
                    result.add(cnt);
                }
            }
            return result.stream().mapToInt(i -> i).toArray();
        }

        class Function {
            int progress;
            int speed;

            public Function(int progress, int speed) {
                this.progress = progress;
                this.speed = speed;
            }

            public void proceed() {
                progress += speed;
            }

            public boolean isCompleted() {
                return 100 <= progress;
            }
        }
    }


}
