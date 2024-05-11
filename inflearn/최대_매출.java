package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 최대_매출 {
    public static int solution(int n, int k, int[] arr) {
        int answer = 0;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        answer = Math.max(answer, sum);

        for(int i = k; i < n; i++) {
            sum += arr[i];
            sum -= arr[i - k];
            answer = Math.max(answer, sum);
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] result = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(solution(N, K, result)));
        bw.flush();

        br.close();
        bw.close();

    }
}
