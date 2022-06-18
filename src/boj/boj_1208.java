package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1208 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        recursive(n >> 1, arr, left, 0, 0);
        recursive(n, arr, right, 0, n >> 1);

        Collections.sort(left);
        Collections.sort(right);

        long answer = 0;
        for (int i : left) {
            if (i == s) {
                answer++;
            }
            int ub = upperBound(right, 0, right.size(), s - i);
            int lb = lowerBound(right, 0, right.size(), s - i);
            answer += ub - lb;
        }

        for (int i : right) {
            if (i == s) {
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }

    static void recursive(int size, int[] arr, List<Integer> list, int num, int idx) {
        if (idx == size) {
            return;
        }
        list.add(num + arr[idx]);
        recursive(size, arr, list, num, idx + 1);
        recursive(size, arr, list, num + arr[idx], idx + 1);
    }

    static int lowerBound(List<Integer> list, int left, int right, int value) {
        if (right <= left) {
            return right;
        }

        int mid = (left + right) / 2;
        if (list.get(mid) < value) {
            return lowerBound(list, mid + 1, right, value);
        } else {
            return lowerBound(list, left, mid, value);
        }
    }

    static int upperBound(List<Integer> list, int left, int right, int value) {
        if (right <= left) {
            return right;
        }

        int mid = (left + right) / 2;
        if (list.get(mid) <= value) {
            return upperBound(list, mid + 1, right, value);
        } else {
            return upperBound(list, left, mid, value);
        }
    }
}
