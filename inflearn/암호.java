package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 암호 {
    public static String solution(int n, String str) {
        String answer = "";

        str = str.replace("#", "1");
        str = str.replace("*", "0");

        for(int i = 0; i < n; i++) {
            String temp = str.substring(0, 7);
            int result = Integer.parseInt(temp, 2);
            answer += (char)(result);
            str = str.substring(7);
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        bw.write(solution(N, str));
        bw.flush();

        br.close();
        bw.close();

    }
}
