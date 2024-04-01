package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = line.charAt(j);
            }
        }

        int horizontal = 0;
        int vertical = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.') {
                    count++;
                    if (count == 2) {
                        horizontal++;
                    }
                } else {
                    count = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (room[j][i] == '.') {
                    count++;
                    if (count == 2) {
                        vertical++;
                    }
                } else {
                    count = 0;
                }
            }
        }

        bw.write(String.valueOf(horizontal) + " " + String.valueOf(vertical));

        bw.close();
        br.close();
    }
}
