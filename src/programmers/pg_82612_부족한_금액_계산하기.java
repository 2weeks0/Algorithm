package programmers;

public class pg_82612_부족한_금액_계산하기 {
    class Solution {
        public long solution(int price, int money, int count) {
            long diff = (long) count * (count + 1) / 2 * price - money;
            return diff < 0 ? 0 : diff;
        }
    }
}
