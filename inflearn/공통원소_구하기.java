package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공통원소_구하기 {
    public static ArrayList<Integer> solution (int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int p1 = 0, p2 = 0;
        Arrays.sort(a);
        Arrays.sort(b);

        while(p1 < n && p2 < m) {
            if(a[p1] == b[p2]) {
                answer.add(a[p1]);
                p1++;
                p2++;
            } else if(a[p1] < b[p2]) {
                p1++;
            } else {
                p2++;
            }
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
            bw.write(String.valueOf(x + " "));
        }

        bw.flush();

        bw.close();
        br.close();

    }
}
