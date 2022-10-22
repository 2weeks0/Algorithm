package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1018 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];
        for (int r = 0; r < n; r++) {
            String s = br.readLine();
            for (int c = 0; c < m; c++) {
                arr[r][c] = s.charAt(c);
            }
        }

        int answer = Integer.MAX_VALUE;
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                cnt1 = 0;
                cnt2 = 0;
                for (int r = i; r < i + 8; r++) {
                    for (int c = j; c < j + 8; c++) {
                        if ((r + c) % 2 == 0 && arr[r][c] == 'W') {
                            cnt1++;
                        } else if ((r + c) % 2 == 1 && arr[r][c] == 'B') {
                            cnt1++;
                        }

                        if ((r + c) % 2 == 0 && arr[r][c] == 'B') {
                            cnt2++;
                        } else if ((r + c) % 2 == 1 && arr[r][c] == 'W') {
                            cnt2++;
                        }
                    }
                }
                answer = Math.min(answer, Math.min(cnt1, cnt2));
            }
        }

        System.out.println(answer);
        br.close();
    }
}
