package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 위장 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    static class Solution {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Set<String> keySet = new HashSet<>();

        public int solution(String[][] clothes) {
            init(clothes);
            return getAnswer();
        }

        public void init(String[][] clothes) {
            for (String[] cloth: clothes) {
                String key = cloth[1];
                if (hashMap.containsKey(key)) {
                    hashMap.put(key, hashMap.get(key) + 1);
                } else {
                    keySet.add(key);
                    hashMap.put(key, 1);
                }
            }
        }

        public int getAnswer() {
            int result = 1;
            for (String key: keySet) {
                result *= (hashMap.get(key) + 1);
            }
            return result - 1;
        }
    }
}

