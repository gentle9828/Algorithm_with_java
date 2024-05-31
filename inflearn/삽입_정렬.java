package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 삽입_정렬 {
    public static int[] solution(int n, int[] arr) {
        for(int i = 1; i < n; i++) {
            int target = arr[i];
            int j = i - 1;
            for(j = i - 1; j >= 0; j--) {
                if(arr[j] > target) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = target;

        }

        return arr;
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

        for (int x : solution(N, result)) {
            bw.write(String.valueOf(x + " "));
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
