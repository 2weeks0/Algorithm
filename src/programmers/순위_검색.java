package programmers;

import java.util.*;

public class 순위_검색 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(
                new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));
    }

    static class Solution {
        int[] answer;

        public int[] solution(String[] info, String[] query) {
            answer = new int[query.length];

            Trie trie = new Trie();
            for (String string : info) {
                trie.addNode(string.split(" "));
            }
            trie.sortScore();

            for (int i = 0; i < query.length; i++) {
                trie.traverse(i, splitQuery(query[i]));
            }
            return answer;
        }

        String[] splitQuery(String query) {
            String[] result = new String[5];
            String[] temp = query.split(" and ");
            for (int i = 0; i < 3; i++) {
                result[i] = temp[i];
            }
            temp = temp[3].split(" ");
            result[3] = temp[0];
            result[4] = temp[1];
            return result;
        }

        class Trie {
            private final Node root = new Node(null);

            public void addNode(String[] split) {
                root.addNode(split, 0);
            }

            public void traverse(int index, String[] query) {
                root.traverse(index, 0, query);
            }

            public void sortScore() {
                root.sortScore();
            }
        }

        class Node {
            String value;
            LinkedList<Node> children;
            ArrayList<Integer> scoreList;

            public Node(String value) {
                this.value = value;
            }

            public void sortScore() {
                if (scoreList != null) {
                    scoreList.sort(Integer::compareTo);
                    return;
                }
                children.forEach(Node::sortScore);
            }

            public void addNode(String[] split, int depth) {
                if (depth == 4) {
                    addScore(Integer.parseInt(split[depth]));
                    return;
                }

                if (children == null) {
                    children = new LinkedList<>();
                }

                for (Node child : children) {
                    if (child.value.equals(split[depth])) {
                        child.addNode(split, depth + 1);
                        return;
                    }
                }

                Node newChild = new Node(split[depth]);
                children.addLast(newChild);
                newChild.addNode(split, depth + 1);
            }

            private void addScore(int score) {
                if (scoreList == null) {
                    scoreList = new ArrayList<>();
                }
                scoreList.add(score);
            }

            public void traverse(int index, int depth, String[] query) {
                if (depth == 4 && (query[depth - 1].equals("-") || value.equals(query[depth - 1]))) {
                    if (scoreList != null) {
                        if (query[depth].equals("-")) {
                            answer[index] += scoreList.size();
                        } else {
                            int idx = binarySearch(0, scoreList.size() - 1, scoreList, Integer.parseInt(query[depth]));
                            if (Integer.parseInt(query[depth]) <= scoreList.get(idx)) {
                                answer[index] += scoreList.size() - idx;
                            }
                        }

                    }
                    return;
                }
                if (query[depth].equals("-")) {
                    children.forEach(it -> it.traverse(index, depth + 1, query));
                } else {
                    for (Node child : children) {
                        if (child.value.equals(query[depth])) {
                            child.traverse(index, depth + 1, query);
                            break;
                        }
                    }
                }
            }


        }

        public int binarySearch(int left, int right, ArrayList<Integer> scoreList, int value) {
            if (left == right) {
                return left;
            }

            int mid = (left + right) / 2;
            if (scoreList.get(mid) < value) {
                return binarySearch(mid + 1, right, scoreList, value);
            } else {
                return binarySearch(left, mid, scoreList, value);
            }
        }
    }


}
