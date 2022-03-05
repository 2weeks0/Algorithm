package programmers;

import java.util.Arrays;

public class 양궁대회 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1})));
    }

    static class Solution {
        static int score;
        static int[] arr;

        public int[] solution(int n, int[] info) {
            recursive(n, info, new int[11], 0, 0);
            if (score <= 0) {
                return new int[]{-1};
            } else {
                return arr;
            }
        }

        void recursive(int n, int[] info, int[] lion, int cnt, int idx) {
            if (n == cnt) {
                int sum = 0;
                for (int i = 0; i < 11; i++) {
                    if (info[i] < lion[i]) {
                        sum += 10 - i;
                    } else if (info[i] != 0) {
                        sum -= 10 - i;
                    }
                }
                if (score <= sum) {
                    if (arr == null) {
                        arr = new int[10];
                    } else if (score == sum) {
                        for (int i = 10; 0 <= i; i--) {
                            if (arr[i] < lion[i]) {
                                break;
                            } else if (lion[i] < arr[i]) {
                                return;
                            }
                        }
                    }
                    arr = lion.clone();
                    score = sum;
                }
                return;
            }

            for (int i = idx; i < 11; i++) {
                if (i == 10) {
                    int temp = lion[i];
                    lion[i] = n - cnt;
                    recursive(n, info, lion, n, i + 1);
                    lion[i] = temp;
                } else if (info[i] + 1 + cnt <= n) {
                    int temp = lion[i];
                    lion[i] = info[i] + 1;
                    recursive(n, info, lion, cnt + info[i] + 1, i + 1);
                    lion[i] = temp;
                }
            }
        }
    }
}
