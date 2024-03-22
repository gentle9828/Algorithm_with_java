package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 대소문자_변환 {
    public static String solution(String input) {
        StringBuilder answer = new StringBuilder();

        for (char x : input.toCharArray()) {
            if(Character.isLowerCase(x)) {
                x = Character.toUpperCase(x);
                answer.append(x);
            } else {
                x = Character.toLowerCase(x);
                answer.append(x);
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = st.nextToken();

        bw.write(solution(input));

        bw.close();
        br.close();
    }
}
