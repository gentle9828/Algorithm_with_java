package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 후위식_연산 {
    public static int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(Character.isDigit(x)) {
                stack.push(x - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(x == '+') {
                    stack.push(lt + rt);
                } else if(x == '-') {
                    stack.push(lt - rt);
                } else if(x == '*') {
                    stack.push(lt * rt);
                } else if(x == '/') {
                    stack.push(lt / rt);
                }
            }
        }
        answer = stack.get(0);


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
