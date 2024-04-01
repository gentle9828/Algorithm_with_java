package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ16926 {
    private static int[][] array;
    private static int N, M, R;

    private static void rotateArray(int[][] array, int N, int M, int R) {
        int layers = Math.min(N, M) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int layerLength = (N + M - 2 - 4 * layer) * 2;
            int actualRotations = R % layerLength;
            for (int rotation = 0; rotation < actualRotations; rotation++) {
                rotateLayer(array, N, M, layer);
            }
        }
    }

    private static void rotateLayer(int[][] array, int N, int M, int layer) {
        int temp = array[layer][layer];
        for (int i = layer; i < M - 1 - layer; i++)
            array[layer][i] = array[layer][i + 1];
        for (int i = layer; i < N - 1 - layer; i++)
            array[i][M - 1 - layer] = array[i + 1][M - 1 - layer];
        for (int i = M - 1 - layer; i > layer; i--)
            array[N - 1 - layer][i] = array[N - 1 - layer][i - 1];
        for (int i = N - 1 - layer; i > layer + 1; i--)
            array[i][layer] = array[i - 1][layer];
        array[layer + 1][layer] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotateArray(array, N, M, R);

        for (int[] row : array) {
            for (int value : row) {
                bw.write(value + " ");
            }
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
