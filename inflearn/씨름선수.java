package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Body implements Comparable<Body> {
    public int height, weight;
    Body(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Body o) {
        return o.height - this.height; // 내림차순 정렬
    }
}

public class 씨름선수 {
    public static int solution(int n, ArrayList<Body> arr) {
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for(Body o : arr) {
            if(o.weight > max) {
                max = o.weight;
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Body> arr = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.add(new Body(h, w));
        }

        bw.write(String.valueOf(solution(N, arr)));
        bw.flush();

        bw.close();
        br.close();
    }
}
