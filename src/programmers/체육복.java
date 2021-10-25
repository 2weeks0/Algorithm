package programmers;

import java.util.Arrays;

public class 체육복 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }


    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            boolean[] students = new boolean[n];
            Arrays.fill(students, true);
            for (int l : lost) {
                students[l - 1] = false;
            }

            Arrays.sort(reserve);
            for (int i = 0; i < reserve.length; i++) {
                int r = reserve[i];
                if (!students[r - 1]) {
                    students[r - 1] = true;
                    reserve[i] = -1;
                }
            }

            for (int r : reserve) {
                if (0 <= r - 2 && !students[r - 2]) {
                    students[r - 2] = true;
                } else if (r != -1 && r < n && !students[r]) {
                    students[r] = true;
                }
            }


            int answer = 0;
            for (boolean student : students) {
                if (student) {
                    answer++;
                }
            }

            return answer;
        }
    }

}
