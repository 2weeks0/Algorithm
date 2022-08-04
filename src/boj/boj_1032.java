package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1032 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] strArray = new String[n];
		for (int i = 0; i < n; i++) {
			strArray[i] = br.readLine();
		}

		StringBuilder sb = new StringBuilder();
		outer: for (int j = 0; j < strArray[0].length(); j++) {
			char c = strArray[0].charAt(j);
			for (int i = 1; i < n; i++) {
				if (c != strArray[i].charAt(j)) {
					sb.append('?');
					continue outer;
				}
			}
			sb.append(c);
		}
		
		System.out.println(sb);
		br.close();
	}
}
