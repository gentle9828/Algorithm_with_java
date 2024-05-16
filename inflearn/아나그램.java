package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 아나그램 {
    public static String solution(String a, String b) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : a.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(char x : b.toCharArray()) {
            if(!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            }
            map.put(x, map.get(x) - 1);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input1 = br.readLine();
        String input2 = br.readLine();

        bw.write(solution(input1, input2));
        bw.flush();

        bw.close();
        br.close();



    }
}
