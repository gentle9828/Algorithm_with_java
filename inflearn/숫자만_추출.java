package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 숫자만_추출 {
    public static int solution(String str) {
        return Integer.valueOf(str.replaceAll("[^0-9]", ""));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String result = br.readLine();

        bw.write(String.valueOf(solution(result)));

        bw.close();
        br.close();
    }
}
