package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2352 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (list.get(list.size() - 1) < arr[i]) {
                list.add(arr[i]);
            } else {
                int pos = binarySearch(list, 0, list.size() - 1, arr[i]);
                list.set(pos, arr[i]);
            }
        }

        System.out.println(list.size());
        br.close();
    }

    static int binarySearch(List<Integer> list, int left, int right, int value) {
        if (right <= left) {
            return right;
        }

        int mid = (left + right) / 2;
        if (list.get(mid) < value) {
            return binarySearch(list, mid + 1, right, value);
        } else {
            return binarySearch(list, left, mid, value);
        }
    }
}
