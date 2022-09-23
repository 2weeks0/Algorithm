package programmers;

import java.util.HashMap;
import java.util.Map;

public class pg_49993_스킬트리 {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < skill.length(); i++) {
                map.put(skill.charAt(i), i);
            }

            int answer = 0;
            outer:
            for (String s : skill_trees) {
                int idx = -1;
                for (int i = 0; i < s.length(); i++) {
                    int temp = map.getOrDefault(s.charAt(i), -1);
                    if (temp == -1) {
                        continue;
                    } else if (idx == temp - 1) {
                        idx = temp;
                    } else {
                        continue outer;
                    }
                }
                answer++;
            }
            return answer;
        }
    }
}
