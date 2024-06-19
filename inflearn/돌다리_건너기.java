package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 돌다리_건너기 {
    static int[] dp;
    public static int solution(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n+1; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n+1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        dp = new int[n+2];

        bw.write(String.valueOf(solution(n)));
        bw.flush();

        bw.close();
        br.close();
    }
}
