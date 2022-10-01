package programmers;

import java.util.*;

public class pg_72411_메뉴_리뉴얼 {
    class Solution {
        public String[] solution(String[] orders, int[] course) {
            for (int i = 0; i < orders.length; i++) {
                char[] temp = orders[i].toCharArray();
                Arrays.sort(temp);
                orders[i] = new String(temp);
            }

            Map<String, Integer> map = new HashMap<>();
            List<String> list = new LinkedList<>();
            for (int c : course) {
                for (String order : orders) {
                    recursive(map, order, c, new int[c], 0, 0);
                }

                int max = map.values().stream().mapToInt(i -> i).max().orElse(0);
                if (1 < max) {
                    for (String key : map.keySet()) {
                        if (map.get(key) == max) {
                            list.add(key);
                        }
                    }
                }
                map.clear();
            }

            return list.stream().sorted().toArray(String[]::new);
        }

        void recursive(Map<String, Integer> map, String order, int r, int[] selected, int cnt, int idx) {
            if (order.length() < r) {
                return;
            } else if (cnt == r) {
                StringBuilder sb = new StringBuilder();
                for (int i : selected) {
                    sb.append(order.charAt(i));
                }
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                return;
            }

            for (int i = idx; i < order.length(); i++) {
                selected[cnt] = i;
                recursive(map, order, r, selected, cnt + 1, i + 1);
            }
        }
    }
}
