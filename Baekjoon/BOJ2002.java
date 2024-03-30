package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ2002 {
    private static int solution(Map<String, Integer> entryOrder, Map<String, Integer> exitOrder) {
        int overtake = 0;

        for (String car : entryOrder.keySet()) {
            if (exitOrder.get(car) > entryOrder.get(car)) {
                continue;
            } else {
                overtake++;
            }
        }

        return overtake;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> entryOrder = new HashMap<>();
        Map<String, Integer> exitOrder = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            entryOrder.put(st.nextToken(), i);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            exitOrder.put(st.nextToken(), i);
        }

        bw.write(String.valueOf(solution(entryOrder, exitOrder)));

        bw.close();
        br.close();
    }
}
