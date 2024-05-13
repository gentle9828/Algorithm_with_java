package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 연속된_자연수의_합 {
    public static int solution(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 1;

        // rt 범위에 =도 포함(1부터 시작)
        for(int rt = 1; rt <= n/2 + 1; rt++) {
            sum += rt;
            if(sum == n) {
                answer++;
            }
            while(sum > n) {
                sum -= lt++;
                if(sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(solution(N)));
        bw.flush();

        br.close();
        bw.close();
    }
}
