package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class BOJ1213_implement {
    private static String solution(String name) {
        Map<Character, Integer> charCount = new TreeMap<>();
        for (char c : name.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        Character oddChar = null;
        StringBuilder half = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCount++;
                oddChar = entry.getKey();
            }
            for (int i = 0; i < entry.getValue() / 2; i++) {
                half.append(entry.getKey());
            }
        }

        if (oddCount > 1) {
            return "I'm Sorry Hansoo";
        }

        String firstHalf = half.toString();
        String secondHalf = half.reverse().toString();
        return oddCount == 1 ? firstHalf + oddChar + secondHalf : firstHalf + secondHalf;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = br.readLine();

        bw.write(solution(name));

        bw.close();
        br.close();
    }
}
