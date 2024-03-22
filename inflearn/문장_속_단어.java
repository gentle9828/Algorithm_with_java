package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 문장_속_단어 {
    public static String solution(String input) {
        String answer = "";
        int min = Integer.MIN_VALUE;
        String[] s = input.split("");
        for (String x : s) {
            int length = x.length();
            if (length > min) {
                min = length;
                answer = x;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        bw.write(solution(input));

        bw.close();
        br.close();
    }
}
