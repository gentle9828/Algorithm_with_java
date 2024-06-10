package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 동전교환 {
    static int n, m, answer = Integer.MAX_VALUE;
    public static void DFS(int L, int sum, Integer[] arr) {
        if(sum > m) {
            return;
        }

        if(L >= answer) {
            return;
        }

        if(sum == m) {
            answer = Math.min(answer, L);
        } else {
            for(int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i], arr);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Collections.reverseOrder());

        DFS(0, 0, arr);
        bw.write(String.valueOf(answer));
        bw.flush();

        bw.close();
        br.close();
    }
}
