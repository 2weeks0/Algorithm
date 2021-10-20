package programmers;

import java.util.LinkedList;

public class 단어_변환 {

    class Solution {
        public int solution(String begin, String target, String[] words) {
            return bfs(begin, target, words);
        }

        public int bfs(String begin, String target, String[] words) {
            int result = 0;
            var queue = new LinkedList<Integer>();
            int[] visited = new int[words.length];
            queue.addLast(-1);

            while (!queue.isEmpty()) {
                var current = queue.pollFirst();
                String currentWord;
                if (current == -1) {
                    currentWord = begin;
                } else {
                    currentWord = words[current];
                }
                System.out.printf("%d, %s\n", current, currentWord);
                if (currentWord.equals(target)) {
                    return visited[current];
                }
                for (int i = 0; i < words.length; i++) {
                    if (visited[i] == 0 && canChange(currentWord, words[i])) {
                        visited[i] = 1;
                        if (current != -1) {
                            visited[i] += visited[current];
                        }
                        queue.addLast(i);
                    }
                }
            }
            return 0;
        }

        public boolean canChange(String current, String next) {
            int cnt = 0;
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) == next.charAt(i)) {
                    cnt++;
                }
                if (1 < cnt) {
                    return false;
                }
            }
            return cnt == 1;
        }
    }


}
