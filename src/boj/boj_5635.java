package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_5635 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] personArr = new Person[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            personArr[i] = new Person(name, day, month, year);
        }
        Arrays.sort(personArr);

        System.out.println(personArr[n - 1].name);
        System.out.println(personArr[0].name);
        br.close();
    }

    static class Person implements Comparable<Person> {
        String name;
        int day;
        int month;
        int year;

        public Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(Person o) {
            if (year == o.year) {
                if (month == o.month) {
                    return Integer.compare(day, o.day);
                }
                return Integer.compare(month, o.month);
            }
            return Integer.compare(year, o.year);
        }
    }
}
