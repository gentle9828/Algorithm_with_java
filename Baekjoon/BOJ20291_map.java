package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ20291_map {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        List<String> keyNames = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            String name = st.nextToken();
            String extension = st.nextToken();
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        for (String x : map.keySet()) {
            keyNames.add(x);
        }

        Collections.sort(keyNames);
        for (String key : keyNames) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
