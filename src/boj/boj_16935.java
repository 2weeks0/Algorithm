package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_16935 {

    static int n;
    static int m;
    static int max;
    static int[] start = {0, 0};
    static int[][] map;
    static int[] commands;

    public static void main(String[] args) throws Exception {
        init();
        solve();
        printAnswer();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        max = Math.max(n, m);
        map = new int[max][max];
        for (int cr = 0; cr < n; cr++) {
            st = new StringTokenizer(br.readLine());
            for (int cc = 0; cc < m; cc++) {
                map[cr][cc] = Integer.parseInt(st.nextToken());
            }
        }
        commands = new int[r];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            commands[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    static void solve() throws Exception {
        for (int command : commands) {
            switch (command) {
                case 1:
                    func1();
                    break;
                case 2:
                    func2();
                    break;
                case 3:
                    func3();
                    break;
                case 4:
                    func4();
                    break;
                case 5:
                    func5();
                    break;
                case 6:
                    func6();
                    break;
                default:
                    throw new Exception();
            }
        }
    }

    // 상하반전
    static void func1() {
        for (int cr = start[0]; cr < start[0] + n / 2; cr++) {
            for (int cc = start[1]; cc < start[1] + m; cc++) {
                int temp = map[cr][cc];
                map[cr][cc] = map[2 * start[0] + n - 1 - cr][cc];
                map[2 * start[0] + n - 1 - cr][cc] = temp;
            }
        }
    }

    // 좌우반전
    static void func2() {
        for (int cr = start[0]; cr < start[0] + n; cr++) {
            for (int cc = start[1]; cc < start[1] + m / 2; cc++) {
                int temp = map[cr][cc];
                map[cr][cc] = map[cr][m - 1 + 2 * start[1] - cc];
                map[cr][m - 1 + 2 * start[1] - cc] = temp;
            }
        }
    }

    // 시계방향 90도
    static void func3() {
        for (int r = 0; r < max / 2; r++) {
            for (int c = r; c < max - 1 - r; c++) {
                int temp = map[r][c];
                map[r][c] = map[max - 1 - c][r];
                map[max - 1 - c][r] = map[max - 1 - r][max - 1 - c];
                map[max - 1 - r][max - 1 - c] = map[c][max - 1 - r];
                map[c][max - 1 - r] = temp;
            }
        }


        start[1] += m - 1;
        int temp = start[1];
        start[1] = start[0];
        start[0] = max - 1 - temp;

        temp = n;
        n = m;
        m = temp;
    }

    // 반시계 90도
    static void func4() {
        for (int r = 0; r < max / 2; r++) {
            for (int c = r; c < max - 1 - r; c++) {
                int temp = map[r][c];
                map[r][c] = map[c][max - 1 - r];
                map[c][max - 1 - r] = map[max - 1 - r][max - 1 - c];
                map[max - 1 - r][max - 1 - c] = map[max - 1 - c][r];
                map[max - 1 - c][r] = temp;
            }
        }
        start[1] += m - 1;
        int temp = start[0];
        start[0] = start[1];
        start[1] = max - 1 - temp;

        temp = n;
        n = m;
        m = temp;
    }

    static void func5() {
        for (int r = start[0]; r < start[0] + n / 2; r++) {
            for (int c = start[1]; c < start[1] + m / 2; c++) {
                int temp = map[r][c];
                map[r][c] = map[n / 2 + r][c];
                map[n / 2 + r][c] = map[n / 2 + r][m / 2 + c];
                map[n / 2 + r][m / 2 + c] = map[r][m / 2 + c];
                map[r][m / 2 + c] = temp;
            }
        }
    }

    static void func6() {
        for (int r = start[0]; r < start[0] + n / 2; r++) {
            for (int c = start[1]; c < start[1] + m / 2; c++) {
                int temp = map[r][c];
                map[r][c] = map[r][m / 2 + c];
                map[r][m / 2 + c] = map[n / 2 + r][m / 2 + c];
                map[n / 2 + r][m / 2 + c] = map[n / 2 + r][c];
                map[n / 2 + r][c] = temp;
            }
        }
    }

    static void printAnswer() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int r = start[0]; r < start[0] + n; r++) {
            for (int c = start[1]; c < start[1] + m; c++) {
                bw.append(String.valueOf(map[r][c])).append(' ');
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
