package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 점수계산 {
    public static int solution(int n, int[] a) {
        int answer = 0;
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if(a[i] == 1) {
                cnt++;
                answer += cnt;

            } else {
                cnt = 0;
                answer += cnt;
            }
        }


        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(solution(N, result)));
        bw.flush();

        br.close();
        bw.close();

    }
}
