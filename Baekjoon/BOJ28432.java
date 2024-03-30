package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class EndWordGame {
    private List<String> records;
    private List<String> candidates;

    public EndWordGame(List<String> records, List<String> candidates) {
        this.records = records;
        this.candidates = candidates;
    }

    public String findValidWord() {
        for (String candidate : candidates) {
            if (isValid(candidate)) {
                return candidate;
            }
        }
        return null;
    }

    private boolean isValid(String candidate) {
        int missingIndex = records.indexOf("?");
        String prev = missingIndex > 0 ? records.get(missingIndex - 1) : "";
        String next = missingIndex < records.size() - 1 ? records.get(missingIndex + 1) : "";

        boolean validPrev = prev.isEmpty() || prev.charAt(prev.length() - 1) == candidate.charAt(0);
        boolean validNext = next.isEmpty() || candidate.charAt(candidate.length() - 1) == next.charAt(0);

        return validPrev && validNext && !records.contains(candidate);
    }
}

public class BOJ28432 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<String> records = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            records.add(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        List<String> candidates = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            candidates.add(st.nextToken());
        }

        EndWordGame game = new EndWordGame(records, candidates);

        bw.write(game.findValidWord());

        bw.close();
        br.close();
    }
}
