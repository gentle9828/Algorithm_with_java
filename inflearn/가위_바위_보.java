package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 가위_바위_보 {
    public static String solution(int n, int[] a, int[] b) {
        String answer = "";

        for(int i = 0; i < n; i++) {
            if(a[i] == b[i]) {
                answer += "D";
            } else if((a[i] == 1 && b[i] == 2) || (a[i] == 2 && b[i] == 3) || (a[i] == 3 && b[i] == 1)) {
                answer += "B";
            } else {
                answer += "A";
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] resultA = new int[N];
        for(int i = 0; i < N; i++) {
            resultA[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] resultB = new int[N];
        for(int i = 0; i < N; i++) {
            resultB[i] = Integer.parseInt(st2.nextToken());
        }

        for(char x : solution(N, resultA, resultB).toCharArray()) {
            bw.write(x + "\n");
        }

        bw.flush();

        br.close();
        bw.close();

    }
}
