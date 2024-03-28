package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ7785_implement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> set = new HashSet<>();

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String value = st.nextToken();

            if (value.equals("enter")) {
                set.add(key);
            } else if (value.equals("leave")) {
                set.remove(key);
            }
        }

        List<String> list = new ArrayList<>(set);
        list.sort(Comparator.reverseOrder());

        for (String x : list) {
            bw.write(x + "\n");
        }

        bw.close();
        br.close();
    }
}
