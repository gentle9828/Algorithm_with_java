package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2480_implement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int answer = 0;
        int[] result = new int[3];
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : result) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for(int x : map.keySet()) {
            if(map.get(x) > max) {
                max = map.get(x);
            }
        }

        for(int x : map.keySet()) {
            if(map.get(x) == max) {
                if(max == 3) {
                    answer = 10000 + (x * 1000);
                } else if(max == 2) {
                    answer = 1000 + (x * 100);
                } else {
                    answer = x * 100;
                }
            }
        }

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
