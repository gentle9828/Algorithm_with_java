package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
    public int start, end;
    Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if(this.end == o.end) {
            return this.start - o.start;
        } else {
            return this.end - o.end;
        }

    }
}

public class 회의실_배정 {
    public static int solution(int n, ArrayList<Time> arr) {
        int cnt = 0;
        Collections.sort(arr);
        int min = Integer.MIN_VALUE;
        for(Time ob : arr) {
            if(ob.start >= min) {
                cnt++;
                min = ob.end;
            }
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Time> arr = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.add(new Time(s, e));
        }

        bw.write(String.valueOf(solution(N, arr)));
        bw.flush();

        bw.close();
        br.close();

    }
}
