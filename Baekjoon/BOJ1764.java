package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class BOJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> unHeard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            unHeard.add(st.nextToken());
        }

        Set<String> unSeen = new HashSet<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            unSeen.add(st.nextToken());
        }

        Set<String> unHeardUnSeen = unHeard.stream()
                .filter(unSeen::contains)
                .collect(Collectors.toCollection(TreeSet::new));

        bw.write(String.valueOf(unHeardUnSeen.size()) + "\n");
        for (String name : unHeardUnSeen) {
            bw.write(name + "\n");
        }

        bw.close();
        br.close();
    }
}
