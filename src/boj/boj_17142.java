package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17142 {
	static final int[] dr = { 0, 1, 0, -1 };
	static final int[] dc = { 1, 0, -1, 0 };
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Point> virusList = new ArrayList<>(m);
		int[][] board = new int[n][n];
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < n; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
				if (board[r][c] == 2) {
					virusList.add(new Point(r, c));
				}
			}
		}

		combination(n, m, board, virusList, new int[m], 0, 0, 0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		br.close();
	}

	static void combination(int n, int m, int[][] board, List<Point> virusList, int[] selectedIndexes, int binary,
			int cnt, int idx) {
		if (cnt == m) {
			answer = Math.min(answer, bfs(n, m, board, virusList, selectedIndexes));
			return;
		}

		for (int i = idx; i < virusList.size(); i++) {
			int temp = (int) Math.pow(2, i);
			if ((binary & temp) == 1) {
				continue;
			}

			binary |= temp;
			selectedIndexes[cnt] = i;
			combination(n, m, board, virusList, selectedIndexes, binary, cnt + 1, i + 1);
			binary ^= temp;
		}
	}

	static int bfs(int n, int m, int[][] board, List<Point> virusList, int[] selectedIndexes) {
		int[][] visited = new int[n][n];
		Queue<Point> queue = new ArrayDeque<>();
		for (int i = 0; i < m; i++) {
			Point virus = virusList.get(selectedIndexes[i]);
			queue.add(virus);
			visited[virus.r][virus.c]++;
		}

		while (!queue.isEmpty()) {
			Point current = queue.poll();

			for (int d = 0; d < dr.length; d++) {
				int nr = current.r + dr[d];
				int nc = current.c + dc[d];
				if (nr < 0 || n <= nr || nc < 0 || n <= nc || board[nr][nc] == 1 || visited[nr][nc] != 0) {
					continue;
				}
				
				visited[nr][nc] = visited[current.r][current.c] + 1;
				queue.add(new Point(nr, nc));
			}
		}

		int result = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (board[r][c] != 1 && visited[r][c] == 0) {
					return Integer.MAX_VALUE;
				} else if (board[r][c] == 0) {
					result = Math.max(result, visited[r][c] - 1);
				}
			}
		}

		return result;
	}

	static class Point {
		int r;
		int c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
