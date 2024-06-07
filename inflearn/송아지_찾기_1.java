package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 송아지_찾기_1 {
    static int answer = 0;
    static int[] dis = {1, -1, 5};
    static int[] ch;
    static Queue<Integer> Q = new LinkedList<>();
    public static int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                int x = Q.poll();
                for(int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if(nx == e) {
                        return L + 1;
                    }
                    if(nx >=1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(BFS(s, e)));
        bw.flush();

        bw.close();
        br.close();

    }
}
