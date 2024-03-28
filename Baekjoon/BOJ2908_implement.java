package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2908_implement {
    public static int solution(String first, String second) {
        String newFirst = "";
        String newSecond = "";

        for (int i = first.length() - 1; i >= 0; i--) {
            newFirst += first.charAt(i);
        }

        for (int i = second.length() - 1; i >= 0; i--) {
            newSecond += second.charAt(i);
        }

        int newFirstInt = Integer.parseInt(newFirst);
        int newSecondInt = Integer.parseInt(newSecond);

        if (newFirstInt > newSecondInt) {
            return newFirstInt;
        } else {
            return newSecondInt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String first = st.nextToken();
        String second = st.nextToken();

        bw.write(String.valueOf(solution(first, second)));

        bw.close();
        br.close();
    }
}
