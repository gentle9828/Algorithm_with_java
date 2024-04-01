package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1018 {
    private static char[][] board;
    private static int N, M;

    private static int findMinRepaints(char[][] board, int N, int M) {
        int minRepaints = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minRepaints = Math.min(minRepaints, calculateRepaints(board, i, j));
            }
        }

        return minRepaints;
    }

    private static int calculateRepaints(char[][] board, int x, int y) {
        int repaintsBW = 0;
        int repaintsWB = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[x + i][y + j] != 'B') repaintsBW++;
                    else repaintsWB++;
                } else {
                    if (board[x + i][y + j] != 'W') repaintsBW++;
                    else repaintsWB++;
                }
            }
        }

        return Math.min(repaintsBW, repaintsWB);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        bw.write(String.valueOf(findMinRepaints(board, N, M)));

        bw.close();
        br.close();
    }
}
