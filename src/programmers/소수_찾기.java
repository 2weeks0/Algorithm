package programmers;

import java.util.*;

public class 소수_찾기 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("011"));
    }

    static class Solution {
        Set<Integer> set = new HashSet<>();

        public int solution(String numbers) {
            init(numbers);
            System.out.println(set);
            return getAnswer();
        }

        public void init(String numbers) {
            char[] nums = new char[numbers.length()];
            for (int i = 0; i < numbers.length(); i++) {
                nums[i] = numbers.charAt(i);
            }
            Arrays.sort(nums);
            StringBuilder stringBuilder = new StringBuilder();
            for (char num : nums) {
                stringBuilder.append(num);
            }
            String temp = stringBuilder.toString();

            do {
                System.out.println(temp);
                for (int i = 0; i < nums.length; i++) {
                    set.add(Integer.parseInt(temp.substring(0, i + 1)));
                }
                temp = nextPermutation(temp);
            } while (temp != null);
        }

        String nextPermutation(String temp) {
            int left = -1;
            for (int i = temp.length() - 2; i >= 0; i--) {
                if (temp.charAt(i) < temp.charAt(i + 1)) {
                    left = i;
                    break;
                }
            }

            if (left == -1) {
                return null;
            }

            int right = left + 1;
            for (int i = left + 1; i < temp.length(); i++) {
                if (temp.charAt(i) > temp.charAt(left)) {
                    right = i;
                }
            }

            char[] result = new char[temp.length()];
            for (int i = 0; i < temp.length(); i++) {
                result[i] = temp.charAt(i);
            }
            result[left] = temp.charAt(right);
            result[right] = temp.charAt(left);

            for (int i = left + 1; i <= (left + temp.length()) / 2; i++) {
                char cc = result[i];
                result[i] = result[temp.length() - i + left];
                result[temp.length() - i + left] = cc;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : result) {
                stringBuilder.append(ch);
            }
            return stringBuilder.toString();
        }

        public int getAnswer() {
            int answer = 0;
            for (int i : set) {
                if (isPrime(i)) {
                    answer++;
                }
            }
            return answer;
        }

        public boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }


}
