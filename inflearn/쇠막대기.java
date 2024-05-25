package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 쇠막대기 {
    public static int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if(str.charAt(i-1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }


        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        bw.write(String.valueOf(solution(input)));
        bw.flush();

        bw.close();
        br.close();

    }
}
