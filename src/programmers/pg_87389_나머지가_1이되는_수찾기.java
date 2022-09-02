package programmers;

public class pg_87389_나머지가_1이되는_수찾기 {
    class Solution {
        public int solution(int n) {
            int i = 2;
            while (n % i != 1) {
                i++;
            }
            return i;
        }
    }
}
