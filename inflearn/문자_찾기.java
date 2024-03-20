package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 문자_찾기 {
    public static int solution(String inputString, char inputChar) {
        int answer = 0;
        inputString = inputString.toLowerCase();
        inputChar = Character.toLowerCase(inputChar);

        for (char x : inputString.toCharArray()) {
            if (x == inputChar) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String inputString = st.nextToken();

        st = new StringTokenizer(br.readLine());
        char x = st.nextToken().charAt(0);

        bw.write(String.valueOf(solution(inputString, x)));

        bw.close();
        br.close();

    }
}
