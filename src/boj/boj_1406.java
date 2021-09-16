package boj;

import java.io.*;
import java.util.LinkedList;

public class boj_1406 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String string = br.readLine();
        final LinkedList<Character> left = new LinkedList<>();
        final LinkedList<Character> right = new LinkedList<>();

        for (int i = 0; i < string.length(); i++) {
            left.add(string.charAt(i));
        }

        final int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            final String input = br.readLine();
            final char command = input.charAt(0);
            switch (command) {
                case 'L':
                    if (!left.isEmpty()) {
                        right.addFirst(left.pollLast());
                    }
                    break;
                case 'D':
                    if (!right.isEmpty()) {
                        left.addLast(right.pollFirst());
                    }
                    break;
                case 'B':
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                    break;
                case 'P':
                    left.addLast(input.charAt(2));
                    break;
            }
        }

        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (char c : left) {
            bw.append(c);
        }
        for (char c : right) {
            bw.append(c);
        }
        bw.flush();
        bw.close();
    }
}
