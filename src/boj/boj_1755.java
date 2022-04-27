package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1755 {
    public static void main(String[] args) throws Exception {
        // 입출력을 위한 버퍼 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // m, n 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // m 이상 n 이하의 정수를 갖는 단어 객체 생성
        Word[] words = new Word[n - m + 1];
        for (int i = m; i <= n; i++) {
            words[i - m] = new Word(i);
        }

        // 정렬
        Arrays.sort(words);

        // 한 줄에 10개씩 출력
        int temp = 0;
        for (Word word : words) {
            bw.append(word.toString()).append(' ');
            if (++temp % 10 == 0) {
                bw.newLine();
            }
        }
        bw.close();
        br.close();
    }

    static class Word implements Comparable<Word> {
        // int형 숫자
        int value;
        // value를 영어로 풀어쓴 단어
        String str;

        // 생성자
        Word(int value) {
            // int형 숫자는 그대로 저장
            this.value = value;

            // value를 토대로 10의 자리 숫자를 영어 단어로 변환
            StringBuilder sb = new StringBuilder();
            int temp = value / 10;
            if (temp != 0) {
                sb.append(parse(temp)).append(' ');
            }
            // 1의 자리 숫자를 영어 단어로 변환
            temp = value % 10;
            sb.append(parse(temp));
            this.str = sb.toString();
        }

        // 숫자를 영어 단어로 바꿔주는 함수
        String parse(int temp) {
            switch (temp) {
                case 0:
                    return "zero";
                case 1:
                    return "one";
                case 2:
                    return "two";
                case 3:
                    return "three";
                case 4:
                    return "four";
                case 5:
                    return "five";
                case 6:
                    return "six";
                case 7:
                    return "seven";
                case 8:
                    return "eight";
                default:
                case 9:
                    return "nine";
            }
        }

        // 영어 단어 사전 순으로 정렬하기 위한 compareTo 함수 정의
        @Override
        public int compareTo(Word o) {
            return str.compareTo(o.str);
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
