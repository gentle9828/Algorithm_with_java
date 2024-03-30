package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Pattern pattern = Pattern.compile("(100+1+|01)+");

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) {
                bw.write("YES" + "\n");
            } else {
                bw.write("NO" + "\n");
            }
        }

        bw.close();
        br.close();
    }
}
