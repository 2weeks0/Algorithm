package programmers;

public class 타겟_넘버 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    static class Solution {
        int answer = 0;

        public int solution(int[] numbers, int target) {
            dfs(0, 0, numbers, target);
            return answer;
        }

        public void dfs(int depth, int num, int[] numbers, int target) {
            if (depth == numbers.length) {
                if (num == target) {
                    answer++;
                }
                return;
            }

            dfs(depth + 1, num + numbers[depth], numbers, target);
            dfs(depth + 1, num - numbers[depth], numbers, target);
        }
    }
}
