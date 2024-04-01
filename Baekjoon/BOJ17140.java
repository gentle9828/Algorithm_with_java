package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BOJ17140 {
    private static int[][] A = new int[101][101];
    private static int r, c, k;

    private static int performR(int rowLength, int colLength) {
        int maxColLength = 0;

        for (int i = 1; i <= rowLength; i++) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int j = 1; j <= colLength; j++) {
                if (A[i][j] > 0) {
                    count.put(A[i][j], count.getOrDefault(A[i][j], 0) + 1);
                }
            }

            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());
            list.sort((o1, o2) -> {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            });

            int idx = 1;
            for (Map.Entry<Integer, Integer> entry : list) {
                if (idx > 100) break;
                A[i][idx++] = entry.getKey();
                A[i][idx++] = entry.getValue();
            }
            for (; idx <= colLength; idx++) A[i][idx] = 0;
            maxColLength = Math.max(maxColLength, list.size() * 2);
        }

        return maxColLength;
    }

    private static int performC(int rowLength, int colLength) {
        int maxRowLength = 0;

        for (int j = 1; j <= colLength; j++) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int i = 1; i <= rowLength; i++) {
                if (A[i][j] > 0) {
                    count.put(A[i][j], count.getOrDefault(A[i][j], 0) + 1);
                }
            }

            List<Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());
            list.sort((o1, o2) -> {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            });

            int idx = 1;
            for (Map.Entry<Integer, Integer> entry : list) {
                if (idx > 100) break;
                A[idx++][j] = entry.getKey();
                A[idx++][j] = entry.getValue();
            }
            for (; idx <= rowLength; idx++) A[idx][j] = 0;
            maxRowLength = Math.max(maxRowLength, list.size() * 2);
        }

        return maxRowLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int rowLength = 3, colLength = 3;
        while (time <= 100) {
            if (r <= rowLength && c <= colLength && A[r][c] == k) {
                bw.write(String.valueOf(time));
                bw.flush();
                return;
            }

            if (rowLength >= colLength) {
                colLength = performR(rowLength, colLength);
            } else {
                rowLength = performC(rowLength, colLength);
            }

            time++;
        }

        bw.write(String.valueOf(-1));
        bw.flush();
        bw.close();
        br.close();
    }
}
