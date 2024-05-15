package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 학급_회장 {
    public static char solution(int n, String arr) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : arr.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for(char x : map.keySet()) {
            if(map.get(x) > max) {
                max = map.get(x);
                answer = x;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String result = br.readLine();

        bw.write(solution(N, result));
        bw.flush();

        bw.close();
        br.close();

    }
}
