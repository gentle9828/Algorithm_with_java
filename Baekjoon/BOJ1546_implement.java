package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1546_implement {
    public static double solution(int[] scores) {
        double maxScore = Arrays.stream(scores).max().orElse(0);

        double average = Arrays.stream(scores)
                .mapToDouble(score -> score / maxScore * 100)
                .average()
                .orElse(0);

        return average;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] scores = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(solution(scores)));

        bw.close();
        br.close();

    }
}
