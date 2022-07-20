package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20327 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for (int cr = 0; cr < n; cr++) {
            st = new StringTokenizer(br.readLine());
            for (int cc = 0; cc < n; cc++) {
                arr[cr][cc] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int dist = (int) Math.pow(2, l);

            if (k < 5) {
                for (int cr = 0; cr < n; cr += dist) {
                    for (int cc = 0; cc < n; cc += dist) {
                        func(n, arr, k, cr, cc, dist);
                    }
                }
            } else if (k == 5) {
                for (int cr = 0; cr < n / 2; cr += dist) {
                    for (int cc = 0; cc < n; cc += dist) {
                        int[][] temp = new int[dist][dist];
                        copy(temp, 0, 0, arr, cr, cc, dist);
                        copy(arr, cr, cc, arr, n - cr - dist, cc, dist);
                        copy(arr, n - cr - dist, cc, temp, 0, 0, dist);
                    }
                }
            } else if (k == 6) {
                for (int cc = 0; cc < n / 2; cc += dist) {
                    for (int cr = 0; cr < n; cr += dist) {
                        int[][] temp = new int[dist][dist];
                        copy(temp, 0, 0, arr, cr, cc, dist);
                        copy(arr, cr, cc, arr, cr, n - dist - cc, dist);
                        copy(arr, cr, n - dist - cc, temp, 0, 0, dist);
                    }
                }
            } else if (k == 7) {
                for (int cr = 0; cr < n / 2; cr += dist) {
                    for (int cc = 0; cc < n / 2; cc += dist) {
                        int[][] temp = new int[dist][dist];
                        copy(temp, 0, 0, arr, cr, cc, dist);
                        copy(arr, cr, cc, arr, n - dist - cc, cr, dist);
                        copy(arr, n - dist - cc, cr, arr, n - dist - cr, n - dist - cc, dist);
                        copy(arr, n - dist - cr, n - dist - cc, arr, cc, n - dist - cr, dist);
                        copy(arr, cc, n - dist - cr, temp, 0, 0, dist);
                    }
                }
            } else {
                for (int cr = 0; cr < n / 2; cr += dist) {
                    for (int cc = 0; cc < n / 2; cc += dist) {
                        int[][] temp = new int[dist][dist];
                        copy(temp, 0, 0, arr, cr, cc, dist);
                        copy(arr, cr, cc, arr, cc, n - dist - cr, dist);
                        copy(arr, cc, n - dist - cr, arr, n - dist - cr, n - dist - cc, dist);
                        copy(arr, n - dist - cr, n - dist - cc, arr, n - dist - cc, cr, dist);
                        copy(arr, n - dist - cc, cr, temp, 0, 0, dist);
                    }
                }
            }
        }

        for (int cr = 0; cr < n; cr++) {
            for (int cc = 0; cc < n; cc++) {
                System.out.print(arr[cr][cc] + " ");
            }
            System.out.println();
        }

        br.close();
    }

    static void copy(int[][] arr1, int r1, int c1, int[][] arr2, int r2, int c2, int dist) {
        for (int i = 0; i < dist; i++) {
            for (int j = 0; j < dist; j++) {
                arr1[r1 + i][c1 + j] = arr2[r2 + i][c2 + j];
            }
        }
    }

    static void func(int n, int[][] arr, int k, int r, int c, int dist) {
        switch (k) {
            case 1:
                op1(arr, r, c, dist);
                return;
            case 2:
                op2(arr, r, c, dist);
                return;
            case 3:
                op3(arr, r, c, dist);
                return;
            case 4:
                op4(arr, r, c, dist);
                return;
            default:
                return;
        }
    }

    static void op1(int[][] arr, int r, int c, int dist) {
        for (int cr = r; cr < r + dist / 2; cr++) {
            for (int cc = c; cc < c + dist; cc++) {
                int temp = arr[cr][cc];
                arr[cr][cc] = arr[2 * r + dist - 1 - cr][cc];
                arr[2 * r + dist - 1 - cr][cc] = temp;
            }
        }
    }

    static void op2(int[][] arr, int r, int c, int dist) {
        for (int cc = c; cc < c + dist / 2; cc++) {
            for (int cr = r; cr < r + dist; cr++) {
                int temp = arr[cr][cc];
                arr[cr][cc] = arr[cr][2 * c + dist - 1 - cc];
                arr[cr][2 * c + dist - 1 - cc] = temp;
            }
        }
    }

    static void op3(int[][] arr, int r, int c, int dist) {
        for (int i = 0; i < dist / 2; i++) {
            for (int j = 0; j < dist / 2; j++) {
                int temp = arr[r + i][c + j];
                arr[r + i][c + j] = arr[r + dist - 1 - j][c + i];
                arr[r + dist - 1 - j][c + i] = arr[r + dist - 1 - i][c + dist - 1 - j];
                arr[r + dist - 1 - i][c + dist - 1 - j] = arr[r + j][c + dist - 1 - i];
                arr[r + j][c + dist - 1 - i] = temp;
            }
        }
    }

    static void op4(int[][] arr, int r, int c, int dist) {
        for (int i = 0; i < dist / 2; i++) {
            for (int j = 0; j < dist / 2; j++) {
                int temp = arr[r + i][c + j];
                arr[r + i][c + j] = arr[r + j][c + dist - 1 - i];
                arr[r + j][c + dist - 1 - i] = arr[r + dist - 1 - i][c + dist - 1 - j];
                arr[r + dist - 1 - i][c + dist - 1 - j] = arr[r + dist - 1 - j][c + i];
                arr[r + dist - 1 - j][c + i] = temp;
            }
        }
    }
}
