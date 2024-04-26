package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 에라토스테네스_체 {
    public static int solution(int n) {
        int answer = 0;
        int[] chae = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            if(chae[i] == 0) {
                answer++;
                for(int j = i; j <= n; j = j + i) {
                    chae[j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }
}
