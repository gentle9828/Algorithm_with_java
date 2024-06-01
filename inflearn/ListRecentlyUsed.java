package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ListRecentlyUsed {
    public static int[] solution(int s, int n, int[] arr) {
        int[] cache = new int[s];
        for(int x : arr) {
            int pos = -1; // 인덱스 번호
            for(int i = 0; i < s; i++) {
                if(x == cache[i]) {
                    pos = i;
                }
            }
            if(pos == -1) {
                for(int i = s - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
                cache[0] = x;
            } else {
                for(int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
                cache[0] = x;
            }
        }

        return cache;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;


        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] result = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : solution(S, N, result)) {
            bw.write(String.valueOf(x + " "));
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
