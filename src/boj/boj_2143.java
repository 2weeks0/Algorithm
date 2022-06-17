package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2143 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> sumAList = getPartialSumList(n, a);
        List<Integer> sumBList = getPartialSumList(m, b);

        long cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : sumAList) {
            if (!map.containsKey(value)) {
                int ub = upperBound(sumBList, 0, sumBList.size(), t - value);
                int lb = lowerBound(sumBList, 0, sumBList.size(), t - value);
                int temp =  ub- lb;
                map.put(value, temp);
            }
            cnt += map.get(value);
        }

        System.out.println(cnt);
        br.close();
    }

    static List<Integer> getPartialSumList(int size, int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = i; j < size; j++) {
                sum += arr[j];
                result.add(sum);
            }
        }
        Collections.sort(result);
        return result;
    }

    static int lowerBound(List<Integer> list, int left, int right, long value) {
        if (right <= left) {
            return left;
        }

        int mid = (left + right) / 2;
        if (list.get(mid) < value) {
            return lowerBound(list, mid + 1, right, value);
        } else {
            return lowerBound(list, left, mid , value);
        }
    }

    static int upperBound(List<Integer> list, int left, int right, long value) {
        if (right <= left) {
            return left;
        }

        int mid = (left + right) / 2;
        if (list.get(mid) <= value) {
            return upperBound(list, mid + 1, right, value);
        } else {
            return upperBound(list, left, mid, value);
        }
    }
}
