package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 조합의_경우수 {
    static int[][] dy = new int[35][35];
    public static int DFS(int n, int r) {
        if(dy[n][r] > 0) return dy[n][r];
        if(n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(DFS(n, r)));
        bw.flush();

        bw.close();
        br.close();

    }
}
