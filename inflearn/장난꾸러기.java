package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 장난꾸러기 {
    public static ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = new int[n];

        for(int i = 0; i < n; i++) {
            tmp[i] = arr[i];
        }

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            if(tmp[i] != arr[i]) {
                answer.add(i + 1);
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[] result = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : solution(N, result)) {
            bw.write(String.valueOf(x + " "));
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
