package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ16935 {
    private static int[][] array;
    private static int N, M;

    private static void reverseUpDown() {
        for (int i = 0; i < N / 2; i++) {
            int[] temp = array[i];
            array[i] = array[N - 1 - i];
            array[N - 1 - i] = temp;
        }
    }

    private static void reverseLeftRight() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int temp = array[i][j];
                array[i][j] = array[i][M - 1 - j];
                array[i][M - 1 - j] = temp;
            }
        }
    }

    private static void rotateRight90() {
        int[][] tempArray = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempArray[j][N - 1 - i] = array[i][j];
            }
        }
        array = tempArray;
        int temp = N;
        N = M;
        M = temp;
    }

    private static void rotateLeft90() {
        int[][] tempArray = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempArray[M - 1 - j][i] = array[i][j];
            }
        }
        array = tempArray;
        int temp = N;
        N = M;
        M = temp;
    }

    private static void moveSectionsClockwise() {
        int[][] tempArray = new int[N][M];
        int halfN = N / 2;
        int halfM = M / 2;
        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfM; j++) {
                tempArray[i][j + halfM] = array[i][j]; // 1 → 2
                tempArray[i + halfN][j + halfM] = array[i][j + halfM]; // 2 → 3
                tempArray[i + halfN][j] = array[i + halfN][j + halfM]; // 3 → 4
                tempArray[i][j] = array[i + halfN][j]; // 4 → 1
            }
        }
        array = tempArray;
    }

    private static void moveSectionsCounterClockwise() {
        int[][] tempArray = new int[N][M];
        int halfN = N / 2;
        int halfM = M / 2;
        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfM; j++) {
                tempArray[i + halfN][j] = array[i][j]; // 1 → 4
                tempArray[i][j] = array[i][j + halfM]; // 2 → 1
                tempArray[i][j + halfM] = array[i + halfN][j + halfM]; // 3 → 2
                tempArray[i + halfN][j + halfM] = array[i + halfN][j]; // 4 → 3
            }
        }
        array = tempArray;
    }

    private static void executeLotate(int operation) {
        switch (operation) {
            case 1:
                reverseUpDown();
                break;
            case 2:
                reverseLeftRight();
                break;
            case 3:
                rotateRight90();
                break;
            case 4:
                rotateLeft90();
                break;
            case 5:
                moveSectionsClockwise();
                break;
            case 6:
                moveSectionsCounterClockwise();
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int r = 0; r < R; r++) {
            executeLotate(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(array[i][j] + " ");
            }
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
