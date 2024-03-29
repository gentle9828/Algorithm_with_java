package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ24313_implement {
    public static boolean checkBigO(int a1, int a0, int c, int n0) {
        for (int i = n0; i <= n0 + 100; i++) {
            if (a1 * i + a0 > c * i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        if (checkBigO(a1, a0, c, n0)) {
            bw.write(String.valueOf(1));
        } else {
            bw.write(String.valueOf(0));
        }

        bw.close();
        br.close();
    }
}
