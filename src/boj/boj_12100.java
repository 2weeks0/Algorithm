package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_12100 {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(n, map, 0);

        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, int[][] map, int cnt) {
        if (cnt == 5) {
            return;
        }

        for (int d = 0; d < 4; d++) {
            int[][] moved = move(n, map, d);
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    answer = Math.max(answer, moved[r][c]);
                }
            }
            recursive(n, moved, cnt + 1);
        }
    }


    static int[][] move(int n, int[][] map, int d) {
        int[][] result = new int[n][];
        for (int r = 0; r < n; r++) {
            result[r] = map[r].clone();
        }

        Deque<Integer> deque = new ArrayDeque<>();
        if (d < 2) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (result[r][c] != 0) {
                        deque.addLast(result[r][c]);
                        result[r][c] = 0;
                    }
                }

                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    if (d % 2 == 0) {
                        int last = deque.pollLast();
                        if (i != size - 1 && !deque.isEmpty() && deque.peekLast() == last) {
                            deque.pollLast();
                            last *= 2;
                            i++;
                        }
                        deque.addFirst(last);
                    } else {
                        int first = deque.pollFirst();
                        if (i != size - 1 && !deque.isEmpty() && deque.peekFirst() == first) {
                            deque.pollFirst();
                            first *= 2;
                            i++;
                        }
                        deque.addLast(first);
                    }
                }
                int idx = d % 2 == 0 ? n - 1 : 0;
                while (!deque.isEmpty()) {
                    if (d % 2 == 0) {
                        result[r][idx--] = deque.pollLast();
                    } else {
                        result[r][idx++] = deque.pollFirst();
                    }
                }
            }
        } else {
            for (int c = 0; c < n; c++) {
                for (int r = 0; r < n; r++) {
                    if (result[r][c] != 0) {
                        deque.addLast(result[r][c]);
                        result[r][c] = 0;
                    }
                }

                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    if (d % 2 == 0) {
                        int last = deque.pollLast();
                        if (i != size - 1 && !deque.isEmpty() && deque.peekLast() == last) {
                            deque.pollLast();
                            last *= 2;
                            i++;
                        }
                        deque.addFirst(last);
                    } else {
                        int first = deque.pollFirst();
                        if (i != size - 1 && !deque.isEmpty() && deque.peekFirst() == first) {
                            deque.pollFirst();
                            first *= 2;
                            i++;
                        }
                        deque.addLast(first);
                    }
                }
                int idx = d % 2 == 0 ? n - 1 : 0;
                while (!deque.isEmpty()) {
                    if (d % 2 == 0) {
                        result[idx--][c] = deque.pollLast();
                    } else {
                        result[idx++][c] = deque.pollFirst();
                    }
                }
            }
        }
        return result;
    }
}
