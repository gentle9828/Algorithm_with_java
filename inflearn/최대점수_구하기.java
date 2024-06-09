package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 최대점수_구하기 {
    static int n, m;
    static int answer = Integer.MIN_VALUE;
    static boolean flag = false;
    public static void DFS(int L, int sum, int time, int[] ps, int[] pt) {
        if(time > m) return;
        if(L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + ps[L], time + pt[L], ps, pt);
            DFS(L + 1, sum, time, ps, pt);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] ps = new int[n];
        int[] pt = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ps[i] = Integer.parseInt(st.nextToken());
            pt[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0, 0, ps, pt);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
