package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 연속_부분수열 {
    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lt = 0;

        for(int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if(sum == m) {
                answer++;
            }
            while(sum > m) {
                sum -= arr[lt];
                if(sum == m) {
                    answer++;
                }
                lt++;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] result = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(solution(N, M, result)));
        bw.flush();

        br.close();
        bw.close();
    }
}
