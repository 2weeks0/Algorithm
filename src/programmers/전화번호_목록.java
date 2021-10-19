package programmers;

import java.util.HashMap;
import java.util.LinkedList;

public class 전화번호_목록 {
    class Solution {
        HashMap<String, Node> hashMap = new HashMap<>();

        public boolean solution(String[] phone_book) {
            makeTrie(phone_book);
            return countLeaf(phone_book) == phone_book.length;
        }

        void makeTrie(String[] phone_book) {
            for (String str: phone_book) {
                Node node = null;
                for (int i = 0; i < str.length(); i++) {
                    String key = str.substring(0, i + 1);
                    if (i == 0) {
                        node = hashMap.containsKey(key) ? hashMap.get(key) : new Node(key);
                        hashMap.putIfAbsent(key, node);
                    } else {
                        boolean hasSameKey = false;
                        for (Node child: node.children) {
                            if (child.data.equals(key)) {
                                hasSameKey = true;
                                node = child;
                                break;
                            }
                        }

                        if (!hasSameKey) {
                            Node child = new Node(str.substring(0, i + 1));
                            node.children.addLast(child);
                            node = child;
                        }
                    }
                }
            }
        }

        int countLeaf(String[] phone_book) {
            int result = 0;
            for (String str: phone_book) {
                String key = str.substring(0, 1);
                if (hashMap.containsKey(key)) {
                    result += hashMap.get(key).getLeafCount();
                    hashMap.remove(key);
                }
            }
            return result;
        }

        class Node {
            String data;
            LinkedList<Node> children = new LinkedList<>();

            public Node(String data) {
                this.data = data;
            }

            int getLeafCount() {
                if (children.isEmpty()) {
                    return 1;
                }

                int result = 0;
                for (Node child: children) {
                    result += child.getLeafCount();
                }
                return result;
            }
        }
    }
}
