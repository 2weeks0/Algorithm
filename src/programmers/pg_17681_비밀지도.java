package programmers;

public class pg_17681_비밀지도 {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            outer: for (int r = 0; r < n; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = n - 1; 0 <= c; c--) {
                    int i = (int) Math.pow(2, c);
                    if (i <= arr1[r] || i <= arr2[r]) {
                        sb.append('#');
                        if (i <= arr1[r]) {
                            arr1[r] -= i;
                        }
                        if (i <= arr2[r]) {
                            arr2[r] -= i;
                        }
                    } else {
                        sb.append(' ');
                    }
                }
                answer[r] = sb.toString();
            }
            return answer;
        }
    }
}
