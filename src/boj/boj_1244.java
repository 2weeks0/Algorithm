package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_1244 {
    static final int MALE = 1;
    static final int FEMALE = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] switches = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        int m = Integer.parseInt(br.readLine());
        Student[] students = new Student[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            students[i] = new Student(gender, num);
        }

        for (Student student: students) {
            student.execute(switches);
        }

        for (int i = 1; i <= n; i++) {

            bw.append(String.valueOf(switches[i] ? 1 : 0)).append(' ');
            if (i % 20 == 0) {
                bw.newLine();
            }
        }

        bw.close();
        br.close();
    }

    static class Student {
        int gender;
        int num;

        public Student(int gender, int num) {
            this.gender = gender;
            this.num = num;
        }

        void execute(boolean[] switches) {
            switch (gender) {
                case MALE:
                    _executeMale(switches);
                    break;
                case FEMALE:
                default:
                    _executeFemale(switches);
                    break;
            }

        }

        void _executeMale(boolean[] switches) {
            for (int i = num; i < switches.length; i += num) {
                switches[i] = !switches[i];
            }
        }

        void _executeFemale(boolean[] switches) {
            int d = 0;
            while (1 <= num - d && num + d < switches.length) {
                if (switches[num - d] != switches[num + d]) {
                    break;
                }
                d++;
            }
            d--;

            for (int i = num - d; i <= num + d; i++) {
                switches[i] = !switches[i];
            }
        }
    }
}
