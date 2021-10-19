package programmers;

public class 도둑질 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 2, 3, 1}));
    }

    static class Solution {
        public int solution(int[] money) {
            int[][] moneySubArray = new int[2][money.length - 1];
            for (int i = 0; i < money.length - 1; i++) {
                moneySubArray[0][i] = money[i + 1];
                moneySubArray[1][i] = money[i];
            }
            int i1 = getMax(moneySubArray[0]);
            int i2 = getMax(moneySubArray[1]);
            return Math.max(i1, i2);
        }

        public int getMax(int[] money) {
            var temp = new int[2][money.length];
            temp[0][0] = 0;
            temp[1][0] = money[0];
            for (int i = 1; i < money.length; i++) {
                temp[0][i] = Math.max(temp[0][i - 1], temp[1][i - 1]);
                temp[1][i] = temp[0][i - 1] + money[i];
            }
            return Math.max(temp[0][money.length - 1], temp[1][money.length - 1]);
        }
    }


}
