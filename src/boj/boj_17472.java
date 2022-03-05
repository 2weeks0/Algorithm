package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_17472 {
    static final int EMPTY = 0;
    static final int LAND = 1;

    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, -1, 0, 1};

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][m];
        int cntLand = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] == LAND && !visited[r][c]) {
                    dfs(n, m, map, visited, r, c, ++cntLand);
                }
            }
        }

        List<Bridge> bridgeList = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            int sc = -1;
            for (int c = 0; c < m; c++) {
                if (map[r][c] != EMPTY) {
                    if (sc == -1 || map[r][sc] == map[r][c]) {
                        sc = c;
                    } else if (map[r][sc] != map[r][c]) {
                        int distance = c - sc - 1;
                        if (1 < distance) {
                            bridgeList.add(new Bridge(map[r][sc], map[r][c], distance));
                        }
                        sc = c;
                    }
                }
            }
        }


        for (int c = 0; c < m; c++) {
            int sr = -1;
            for (int r = 0; r < n; r++) {
                if (map[r][c] != EMPTY) {
                    if (sr == -1 || map[sr][c] == map[r][c]) {
                        sr = r;
                    } else if (map[sr][c] != map[r][c]) {
                        int distance = r - sr - 1;
                        if (1 < distance) {
                            bridgeList.add(new Bridge(map[sr][c], map[r][c], distance));
                        }
                        sr = r;
                    }
                }
            }
        }


        System.out.println(mst(cntLand, bridgeList));
        br.close();
    }

    static int mst(int n, List<Bridge> bridgeList) {
        int result = 0;
        int cnt = 0;
        int[] set = makeSet(n);
        Collections.sort(bridgeList);
        for (Bridge bridge : bridgeList) {
            if (unionSet(set, bridge.from - 1, bridge.to - 1)) {
                result += bridge.distance;
                cnt++;
            }
            if (cnt == n - 1) {
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            if (unionSet(set, 0, i)) {
                return -1;
            }
        }
        return result;
    }

    static int[] makeSet(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        return result;
    }

    static int findSet(int[] arr, int a) {
        if (arr[a] == a) {
            return a;
        }
        return arr[a] = findSet(arr, arr[a]);
    }

    static boolean unionSet(int[] arr, int a, int b) {
        int rootA = findSet(arr, a);
        int rootB = findSet(arr, b);
        if (rootA == rootB) {
            return false;
        }
        arr[rootB] = rootA;
        return true;
    }

    static void dfs(int n, int m, int[][] map, boolean[][] visited, int r, int c, int value) {
        visited[r][c] = true;
        map[r][c] = value;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (0 <= nr && nr < n && 0 <= nc && nc < m && map[nr][nc] == LAND && !visited[nr][nc]) {
                dfs(n, m, map, visited, nr, nc, value);
            }
        }
    }

    static class Bridge implements Comparable<Bridge> {
        int from;
        int to;
        int distance;

        public Bridge(int from, int to, int distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Bridge o) {
            return Integer.compare(distance, o.distance);
        }
    }
}
