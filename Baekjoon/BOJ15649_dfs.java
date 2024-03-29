package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ15649_dfs {
    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int value : arr) {
                sb.append(value).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 아직 방문하지 않았다면
                visited[i] = true; // 방문 상태로 변경
                arr[depth] = i; // 현재 깊이의 값을 i로 설정
                dfs(N, M, depth + 1); // 다음 깊이로 재귀 호출
                visited[i] = false; // 재귀가 끝나면 방문 상태를 다시 되돌림
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N + 1];

        dfs(N, M, 0);

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
