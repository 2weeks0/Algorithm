package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_10845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String ex = st.nextToken();

            switch (ex) {
                case "push":
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.append(deque.isEmpty() ? "-1" : String.valueOf(deque.poll())).append('\n');
                    break;
                case "size":
                    bw.append(String.valueOf(deque.size())).append('\n');
                    break;
                case "empty":
                    bw.append(deque.isEmpty() ? '1' : '0').append('\n');
                    break;
                case "front":
                    bw.append(deque.isEmpty() ? "-1" : String.valueOf(deque.peekFirst())).append('\n');
                    break;
                case "back":
                    bw.append(deque.isEmpty() ? "-1" : String.valueOf(deque.peekLast())).append('\n');
                    break;
            }
        }
        bw.close();
        br.close();
    }
}

