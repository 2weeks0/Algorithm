package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class boj_1021 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());
        final ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        final int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        final ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        for (int target : list) {
            final int index = indexOf(deque, target);
            int cnt;
            if (index > deque.size() / 2) {
                cnt = deque.size() - index;
                for (int i = 0; i < cnt; i++) {
                    deque.addFirst(Objects.requireNonNull(deque.pollLast()));
                }
            } else {
                cnt = index;
                for (int i = 0; i < cnt; i++) {
                    deque.addLast(Objects.requireNonNull(deque.pollFirst()));
                }
            }
            answer += cnt;
            deque.pollFirst();
        }

        System.out.println(answer);
    }

    static int indexOf(ArrayDeque<Integer> deque, Object target) {
        int result = -1;
        final Object[] array = deque.toArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                result = i;
            }
        }
        return result;
    }
}

// 1 2 3 4 5 6 7 8 9 10
// 2 3 4 5 6 7 8 9 10 1
// 3 4 5 6 7 8 9 10 1