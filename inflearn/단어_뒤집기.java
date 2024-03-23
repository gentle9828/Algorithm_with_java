package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 단어_뒤집기 {
    public static String[] solution(int n, String[] str) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            answer[i] = "";
            for(int k = str[i].length() - 1; k >= 0; k--) {
                answer[i] += str[i].charAt(k);
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] result = new String[N];
        for(int i = 0; i < N; i++) {
            result[i] = br.readLine();
        }

        for(String s : solution(N, result)) {
            bw.write(s + "\n");
        }
        bw.flush();

        br.close();
        bw.close();

    }
}
