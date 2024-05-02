package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 등수_구하기 {
    public static int[] solution(int n, int[] a) {
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
            int cnt = n + 1;
            for(int j = 0; j < n; j++) {
                if(a[i] >= a[j]) {
                    cnt--;
                }
            }
            answer[i] = cnt;

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

        for (int x : solution(N, result)) {
            bw.write(x + " ");
        }

        bw.flush();

        bw.close();
        br.close();


    }
}
