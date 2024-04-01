package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1022 {
    private static int getValue(int r, int c) {
        int layer = Math.max(Math.abs(r), Math.abs(c));
        int max = (2 * layer + 1) * (2 * layer + 1);
        if (r == layer)
            return max - (layer - c);
        max -= (2 * layer);
        if (c == -layer)
            return max - (layer - r);
        max -= (2 * layer);
        if (r == -layer)
            return max - (c + layer);
        max -= (2 * layer);

        return max - (r + layer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int maxNum = Math.max(Math.max(getValue(r1, c1), getValue(r1, c2)), Math.max(getValue(r2, c1), getValue(r2, c2)));
        int maxLength = String.valueOf(maxNum).length();

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                int value = getValue(i, j);
                bw.write(String.format("%" + maxLength + "d ", value));
            }
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
