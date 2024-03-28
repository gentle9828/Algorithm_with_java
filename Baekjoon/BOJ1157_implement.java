package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1157_implement {
    public static Character solution(String input) {
        input = input.toUpperCase();

        Map<Character, Integer> map = new HashMap<>();
        for (char x : input.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }


        int max = -1;
        char answer = 0;
        for (char x : map.keySet()) {
            if (max < map.get(x)) {
                max = map.get(x);
                answer = x;
            }
        }

        int sameCount = 0;
        for (char x : map.keySet()) {
            if (max == map.get(x)) {
                sameCount++;
            }
        }

        if (sameCount > 1) {
            return '?';
        } else {
            return answer;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = st.nextToken();

        bw.write(solution(input));

        bw.close();
        br.close();
    }
}
