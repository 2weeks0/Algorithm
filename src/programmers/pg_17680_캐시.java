package programmers;

import java.util.*;

public class pg_17680_캐시 {
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            if (cacheSize == 0) {
                return 5 * cities.length;
            }

            int answer = 0;
            List<String> list = new LinkedList<>();
            for (String c : cities) {
                String city = c.toUpperCase();
                int idx = list.indexOf(city);
                if (idx != -1) {
                    answer++;
                    list.remove(idx);
                    list.add(city);
                    continue;
                }

                answer += 5;
                if (list.size() == cacheSize) {
                    list.remove(0);
                }
                list.add(city);
            }
            return answer;
        }
    }
}