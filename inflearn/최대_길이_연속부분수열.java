package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 최대_길이_연속부분수열 {
    public static int solution(int n, int k, int[] arr) {
        int answer = 0;
        int cnt = 0;
        int lt = 0;

        for(int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) {
                cnt++;
            }
            while(cnt > k) {
                if(arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
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
