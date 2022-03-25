package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16948 {
    static final int[] dr = {-2, -2, 0, 0, 2, 2};
    static final int[] dc = {-1, 1, -2, 2, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, r1, c1, r2, c2));
        br.close();
    }

    static int bfs(int n, int r1, int c1, int r2, int c2) {
        int[][] visited = new int[n][n];
        visited[r1][c1] = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r1, c1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == r2 && current[1] == c2) {
                return visited[r2][c2] - 1;
            }

            for (int d = 0; d < dr.length; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];
                if (nr < 0 || n <= nr || nc < 0 || n <= nc || visited[nr][nc] != 0) {
                    continue;
                }
                visited[nr][nc] = visited[current[0]][current[1]] + 1;
                queue.add(new int[]{nr, nc});
            }
        }

        return -1;
    }
}
