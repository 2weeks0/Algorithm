package boj;

public class pg_12927_야근_지수 {
    import java.util.*;

    class Solution {
        public long solution(int n, int[] works) {
            Integer[] workArr = new Integer[works.length];
            for (int i = 0; i < works.length; i++) {
                workArr[i] = Integer.valueOf(works[i]);
            }
            Arrays.sort(workArr, (a, b) -> b - a);
            List<int[]> list = new ArrayList<>();

            int temp = workArr[0];
            for (int i = 1; i < workArr.length; i++) {
                if (temp != workArr[i]) {
                    list.add(new int[]{i, temp - workArr[i]});
                    temp = workArr[i];
                }
            }

            for (int i = 0; i < list.size(); i++) {
                int[] arr = list.get(i);
                if (arr[0] * arr[1] <= n) {
                    for (int j = 0; j < arr[0]; j++) {
                        workArr[j] -= arr[1];
                    }
                    n -= arr[0] * arr[1];
                } else {
                    outer: while (0 < n) {
                        for (int j = 0; j < arr[0]; j++) {
                            if (workArr[i] == 0) {
                                break outer;
                            }
                            workArr[j]--;
                            n--;
                            if (n == 0) {
                                break;
                            }
                        }

                    }
                }
            }
            outer: while (0 < n) {
                for (int i = 0; i < workArr.length; i++) {
                    if (workArr[i] == 0) {
                        break outer;
                    }
                    workArr[i]--;
                    n--;
                    if (n == 0) {
                        break;
                    }
                }
            }

            long answer = 0;
            for (int i : workArr) {
                answer += i * i;
            }
            return answer;
        }
    }
}
