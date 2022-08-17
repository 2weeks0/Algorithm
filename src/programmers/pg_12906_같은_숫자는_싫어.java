package programmers;

import java.util.*;

public class 같은_숫자는_싫어 {

    public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (stack.isEmpty() || stack.peek() != i) {
                stack.push(i);
            }
        }
        
        
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; 0 <= i; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}


}
