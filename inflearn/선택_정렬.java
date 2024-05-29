package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 선택_정렬 {
    public static int[] solution(int n, int[] input) {
        for(int i = 0; i < n; i++) {
            int idx = i;
            for(int j = i + 1; j < n; j++) {
                if(input[idx] > input[j]) {
                    idx = j;
                }
            }
            int tmp = input[i];
            input[i] = input[idx];
            input[idx] = tmp;
        }

        return input;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : solution(N, result)) {
            bw.write(String.valueOf(x + " "));
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
