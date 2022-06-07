package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1302 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (!map.containsKey(name)) {
                names.add(name);
                map.put(name, 0);
            }
            map.put(name, map.get(name) + 1);
        }

        names.sort((a, b) -> {
            if (Objects.equals(map.get(a), map.get(b))) {
                return a.compareTo(b);
            }
            return map.get(b).compareTo(map.get(a));
        });
        System.out.println(names.get(0));
        br.close();
    }
}

