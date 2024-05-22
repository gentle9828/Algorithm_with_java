package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 크레인_인형뽑기 {
    public static int solution(int n, int[][] arr, int moves, int[] move) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int pos : move) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i][pos-1] != 0) {
                    int tmp = arr[i][pos-1];
                    arr[i][pos-1] = 0; // 인형을 가져왔으니까 그 자리는 0으로 바꿔준다.
                    if(!stack.isEmpty() && tmp == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] result = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int moves = Integer.parseInt(br.readLine());
        int[] move = new int[moves];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < moves; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(solution(N, result, moves, move)));
        bw.flush();

        bw.close();
        br.close();

    }
}
