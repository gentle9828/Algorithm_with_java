package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15663_dfs {
    private static int N, M;
    private static int[] arr, nums;
    private static boolean[] visit;
    private static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {

        if (depth == M) {
            for (int value : arr) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        int last = -1;
        for (int i = 1; i <= N; i++) {
            if (visit[i]) {
                continue;
            }

            if (last != nums[i]) {
                visit[i] = true;
                arr[depth] = nums[i];
                last = nums[i];
                dfs(depth + 1);
                visit[i] = false;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N + 1];

        nums = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0);

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
