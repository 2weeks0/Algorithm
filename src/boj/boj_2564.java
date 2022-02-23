package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2564 {
    static final int NORTH = 1;
    static final int SOUTH = 2;
    static final int WEST = 3;
    static final int EAST = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        st = new StringTokenizer(br.readLine());
        int[] donguen = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        int answer = 0;
        for (int[] point : points) {
            answer += getMinDistance(w, h, donguen, point);
        }
        System.out.println(answer);
        br.close();
    }

    static int getMinDistance(int w, int h, int[] dongeun, int[] point) {
        if (dongeun[0] == point[0]) {
            return Math.abs(dongeun[1] - point[1]);
        } else if ((dongeun[0] == SOUTH && point[0] == NORTH)
                || (dongeun[0] == NORTH && point[0] == SOUTH)) {
            return h + Math.min(dongeun[1] + point[1], 2 * w - dongeun[1] - point[1]);
        } else if ((dongeun[0] == EAST && point[0] == WEST)
                || (dongeun[0] == WEST && point[0] == EAST)) {
            return w + Math.min(dongeun[1] + point[1], 2 * h - dongeun[1] - point[1]);
        } else if (dongeun[0] == WEST) {
            if (point[0] == SOUTH) {
                return point[1] + h - dongeun[1];
            } else {
                return point[1] + dongeun[1];
            }
        } else if (dongeun[0] == EAST) {
            if (point[0] == SOUTH) {
                return w - point[1] + h - dongeun[1];
            } else {
                return w - point[1] + dongeun[1];
            }
        } else if (dongeun[0] == SOUTH) {
            if (point[0] == WEST) {
                return dongeun[1] + h - point[1];
            } else {
                return w - dongeun[1] + h - point[1];
            }
        } else {
            if (point[0] == WEST) {
                return dongeun[1] + point[1];
            } else {
                return w - point[1] + point[1];
            }
        }
    }
}
