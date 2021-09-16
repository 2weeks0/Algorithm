package boj;

import java.io.*;
import java.util.LinkedList;

public class boj_5397 {
    public static void main(String[] args) throws IOException {
        final LinkedList<Character> left = new LinkedList<>();
        final LinkedList<Character> right = new LinkedList<>();

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            final String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                final char c = input.charAt(j);
                switch (c) {
                    case '<':
                        if (!left.isEmpty()) {
                            right.addFirst(left.pollLast());
                        }
                        break;
                    case '>':
                        if (!right.isEmpty()) {
                            left.addLast(right.pollFirst());
                        }
                        break;
                    case '-':
                        if (!left.isEmpty()) {
                            left.pollLast();
                        }
                        break;
                    default:
                        left.addLast(c);
                        break;
                }
            }

            final int leftSize = left.size();
            for (int j = 0; j < leftSize; j++) {
                bw.append(left.pollFirst());
            }
            final int rightSize = right.size();
            for (int j = 0; j < rightSize; j++) {
                bw.append(right.pollFirst());
            }
            bw.append('\n');
            bw.flush();
        }
        bw.close();
    }
}
