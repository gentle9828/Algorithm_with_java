package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ5525 {
    private static int solution(String S, int N) {
        int count = 0;
        int patternCount = 0;

        for (int i = 1; i < S.length() - 1; i++) {
                if (S.charAt(i-1) == 'I' && S.charAt(i) == 'O' && S.charAt(i+1) == 'I') {
                    patternCount++;
                    if (patternCount == N) {
                        count++;
                        patternCount--;
                    }
                    i++;
                } else {
                    patternCount = 0;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        bw.write(String.valueOf(solution(S, N)));

        bw.close();
        br.close();
    }
}
