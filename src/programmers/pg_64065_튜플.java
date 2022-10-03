package programmers;

import java.util.*;

public class pg_64065_튜플 {

    class Solution {
        public int[] solution(String s) {
            List<Integer> answer = new ArrayList<>();
            Map<Integer, Set<Integer>> setMap = new HashMap<>();
            int idxStart = 0, idxEnd = 0;
            for (int i = 1; i < s.length() - 1; i++) {
                char c = s.charAt(i);
                if (c == '{') {
                    idxStart = i;
                } else if (c == '}') {
                    idxEnd = i;
                    String[] splited = s.substring(idxStart + 1, idxEnd).split(",");
                    Set<Integer> temp = new HashSet<>();
                    for (String num : splited) {
                        temp.add(Integer.parseInt(num));
                    }
                    setMap.put(temp.size(), temp);
                }
            }

            int idx = 1;
            while (setMap.containsKey(idx)) {
                for (int i : setMap.get(idx)) {
                    if (idx != 1 && setMap.get(idx - 1).contains(i)) {
                        continue;
                    }
                    answer.add(i);
                    break;
                }
                idx++;
            }
            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}