package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 수열_추측하기 {
    static int[] b, p, ch;
    static int n, f;
    static boolean flag = false;
    static int[][] dy = new int[35][35];

    public static int combi(int n, int r) {
        if(dy[n][r] > 0) return dy[n][r];
        if(n == r || r == 0) return 1;
        else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    public static void DFS(int L, int sum) {
        if(flag) return;
        if(L == n) {
            if(sum == f) {
                for(int x : p) {
                    System.out.print(x + " ");
                    flag = true;
                }
            }
        } else {
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum + (p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];
        for(int i = 0; i < n; i++) {
            b[i] = combi(n - 1, i);
        }

        DFS(0,0);
    }
}
