package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj_2263 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] inOrder = new int[n];
        int[] postOrder = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        preOrder(inOrder, postOrder, new int[]{0, n}, new int[]{0, n}, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    static void preOrder(int[] inOrder, int[] postOrder, int[] inOrderIdx, int[] postOrderIdx, BufferedWriter bw) throws Exception {
        if (inOrderIdx[0] >= inOrderIdx[1] || postOrderIdx[0] >= postOrderIdx[1]) {
            return;
        }

        int root = postOrder[postOrderIdx[1] - 1];
        int idx = 0;
        for (int i =inOrderIdx[0]; i < inOrderIdx[1]; i++) {
            if (inOrder[i] == root) {
                idx = i;
                break;
            }
        }

        bw.append(String.valueOf(root)).append(' ');

        if (idx != inOrderIdx[0]) {
            preOrder(inOrder, postOrder, new int[]{inOrderIdx[0], idx}, new int[]{postOrderIdx[0], postOrderIdx[0] + idx - inOrderIdx[0]}, bw);
        }

        if (idx != inOrderIdx[1] - 1) {
            preOrder(inOrder, postOrder, new int[]{idx + 1, inOrderIdx[1]}, new int[]{postOrderIdx[0] + idx - inOrderIdx[0], postOrderIdx[1] - 1}, bw);
        }
    }
}
