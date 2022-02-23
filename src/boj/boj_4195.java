package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj_4195 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            Map<String, Network> map = new HashMap<>();
            int f = Integer.parseInt(br.readLine());
            for (int i = 0; i < f; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                map.putIfAbsent(a, new Network(a, 1));
                map.putIfAbsent(b, new Network(b, 1));
                unionSet(map, a, b);

                bw.append(String.valueOf(map.get(a).size)).append('\n');
            }
        }
        bw.close();
        br.close();
    }

    static void unionSet(Map<String, Network> map, String a, String b) {
        Network networkA = findSet(map, a);
        Network networkB = findSet(map, b);
        if (networkA.root.equals(networkB.root)) {
            return;
        }
        networkA.size += networkB.size;
        map.put(networkB.root, networkA);
    }

    static Network findSet(Map<String, Network> map, String a) {
        if (map.get(a).root.equals(a)) {
            return map.get(a);
        }
        Network root = findSet(map, map.get(a).root);
        map.put(a, root);
        return root;
    }

    static class Network {
        String root;
        int size;

        public Network(String root, int size) {
            this.root = root;
            this.size = size;
        }
    }
}
