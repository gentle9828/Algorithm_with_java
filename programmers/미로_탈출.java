package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 미로_탈출 {
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    start[0] = i; start[1] = j;
                } else if (c == 'L') {
                    lever[0] = i; lever[1] = j;
                } else if (c == 'E') {
                    exit[0] = i; exit[1] = j;
                }
            }
        }

        int timeToLever = bfs(start, lever, maps);
        if (timeToLever == -1) return -1;

        int timeToExit = bfs(lever, exit, maps);
        if (timeToExit == -1) return -1;

        return timeToLever + timeToExit;
    }

    private int bfs(int[] start, int[] target, String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            if (r == target[0] && c == target[1]) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (maps[nr].charAt(nc) != 'X' && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc, dist + 1});
                    }
                }
            }
        }

        return -1;
    }
}
