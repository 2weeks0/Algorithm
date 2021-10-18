package programmers;

import java.util.HashMap;

public class 완주하지_못한_선수 {
    class Solution {
        public String solution(String[] participant, String[] completion) throws Exception {
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (String str : completion) {
                if (hashMap.containsKey(str)) {
                    hashMap.put(str, hashMap.get(str) + 1);
                } else {
                    hashMap.put(str, 1);
                }
            }

            for (String str : participant) {
                if (hashMap.containsKey(str)) {
                    if (hashMap.get(str) == 1) {
                        hashMap.remove(str);
                    } else {
                        hashMap.put(str, hashMap.get(str) - 1);
                    }
                } else {
                    return str;
                }
            }
            throw new Exception();
        }
    }
}
