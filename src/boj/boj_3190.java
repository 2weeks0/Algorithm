package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_3190 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(br.readLine());
        final int[][] apple = new int[n + 1][n + 1];

        final int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int r = Integer.parseInt(st.nextToken());
            final int c = Integer.parseInt(st.nextToken());
            apple[r][c] = 1;
        }

        final Map<Integer, Character> turnMap = new HashMap<>();
        final int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int key = Integer.parseInt(st.nextToken());
            final char direction = st.nextToken().charAt(0);
            turnMap.put(key, direction);
        }

        int direction = 0;
        final int[] dx = {1, 0 , -1, 0};
        final int[] dy = {0, 1, 0, -1};
        int sec = 0;
        final LinkedList<Point> snake = new LinkedList<>();
        snake.addFirst(new Point(1, 1));

        while (true) {
            sec++;
            final Point head = snake.peekFirst();
            assert head != null;
            final Point newHead = new Point(head.x + dx[direction], head.y + dy[direction]);

            if (newHead.x < 1 || newHead.x > n || newHead.y < 1 || newHead.y > n) {
                System.out.println(sec);
                return;
            }

            for (Point point : snake) {
                if (point.x == newHead.x && point.y == newHead.y) {
                    System.out.println(sec);
                    return;
                }
            }

            snake.addFirst(newHead);

            if (apple[newHead.y][newHead.x] == 1) {
                apple[newHead.y][newHead.x] = 0;
            } else {
                snake.pollLast();
            }

            if (turnMap.containsKey(sec)) {
                final char d = turnMap.get(sec);
                turnMap.remove(sec);
                if (d == 'D') {
                    direction = (direction + 1) % 4;
                } else {
                    if (direction == 0) {
                        direction = 3;
                    } else {
                        direction -= 1;
                    }
                }
            }
        }
    }

    private static class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

