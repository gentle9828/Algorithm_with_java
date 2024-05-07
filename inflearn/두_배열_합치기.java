package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 두_배열_합치기 {
    public static ArrayList<Integer> solution (int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m) {
            if(a[p1] < b[p2]) {
                answer.add(a[p1]);
                p1++;
            } else {
                answer.add(b[p2]);
                p2++;
            }
        }
        while(p1 < n) {
            answer.add(a[p1]);
            p1++;
        }

        while(p2 < m) {
            answer.add(b[p2]);
            p2++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] b = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st2.nextToken());
        }

        for(int x : solution(N, M, a, b)) {
            bw.write(String.valueOf(x) + " ");
        }

        bw.flush();

        br.close();
        bw.close();

    }
}
