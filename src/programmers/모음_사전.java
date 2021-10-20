package programmers;

import java.util.HashSet;

public class 모음_사전 {
    public static void main(String[] args) {
        String s = "0.1";
        System.out.println(Double.parseDouble(s));
    }

    class Solution {
        public int solution(String word) {
            HashSet<String> dictionary = new HashSet<>();
            char[] vowels = {'a', 'e', 'i', 'o', 'u'};
            recursive(dictionary, "", vowels);
            var sortedDictionary = dictionary.stream().sorted().toArray();
            for (int i = 0; i < sortedDictionary.length; i++) {
                System.out.println(sortedDictionary[i]);
                if (sortedDictionary[i].equals(word)) {
                    return i + 1;
                }
            }
            return 0;
        }

        public void recursive(HashSet<String> dictionary, String str, char[] vowels) {
            if (vowels.length == str.length()) {
                return;
            }

            for (char vowel : vowels) {
                String newWord = str + vowel;
                dictionary.add(newWord);
                recursive(dictionary, newWord, vowels);
            }
        }


    }


}
