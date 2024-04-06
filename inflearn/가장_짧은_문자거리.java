package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 가장_짧은_문자거리 {
    public static int[] solution(String str, char c) {
        int[] answer = new int[str.length()];

        int p = 1000;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

        p = 1000;
        for(int i = str.length() - 1; i >=0; i--) {
            if(str.charAt(i) == c) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = st.nextToken();
        char c = st.nextToken().charAt(0);

        for(int x : solution(input, c)) {
            System.out.print(x + " ");
        }

    }
}
