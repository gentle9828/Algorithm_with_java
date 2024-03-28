package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ27160_implement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String fruit = st.nextToken();
            int fruitCount = Integer.parseInt(st.nextToken());

            if (map.containsKey(fruit)) {
                map.put(fruit, map.get(fruit) + fruitCount);
            } else {
                map.put(fruit, fruitCount);
            }
        }

        if (map.containsValue(5)) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.close();
        br.close();
    }
}
