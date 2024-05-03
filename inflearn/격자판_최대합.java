package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 격자판_최대합 {
    public static int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        int leftSum = 0;
        int rightSum = 0;

        for(int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for(int j = 0; j < n; j++) {
                rowSum += arr[i][j];
                colSum += arr[j][i];
            }
            answer = Math.max(answer, rowSum);
            answer = Math.max(answer, colSum);
            leftSum += arr[i][i];
            rightSum += arr[i][n - i - 1];
            answer = Math.max(answer, leftSum);
            answer = Math.max(answer, rightSum);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] result = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(String.valueOf(solution(N, result)));
        bw.flush();

        bw.close();
        br.close();

    }
}
