package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point2 {
    public int x, y;

    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 미로의_최단거리_통로 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;

    public static void BFS(int x, int y) {
        Queue<Point2> Q = new LinkedList<>();
        Q.offer(new Point2(x, y));
        board[x][y] = 1;
        while(!Q.isEmpty()) {
            Point2 tmp = Q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx  >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point2(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        board = new int[8][8];
        dis = new int[8][8];
        for(int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(1, 1);
        if(dis[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[7][7]);
        }


    }
}
