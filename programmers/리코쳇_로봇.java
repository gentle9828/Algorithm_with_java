package programmers;

import java.util.*;

public class 리코쳇_로봇 {
    private static class State {
        int r, c, moves;

        public State(int r, int c, int moves) {
            this.r = r;
            this.c = c;
            this.moves = moves;
        }
    }

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();

        char[][] grid = new char[n][m];
        int startR = 0, startC = 0;

        for (int i = 0; i < n; i++) {
            grid[i] = board[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'R') {
                    startR = i;
                    startC = j;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        boolean[][] visited = new boolean[n][m];
        Deque<State> queue = new ArrayDeque<>();

        queue.offer(new State(startR, startC, 0));
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (grid[current.r][current.c] == 'G') {
                return current.moves;
            }

            for (int i = 0; i < 4; i++) {
                int nr = current.r;
                int nc = current.c;

                while (nr + dr[i] >= 0 && nr + dr[i] < n &&
                        nc + dc[i] >= 0 && nc + dc[i] < m &&
                        grid[nr + dr[i]][nc + dc[i]] != 'D') {
                    nr += dr[i];
                    nc += dc[i];
                }

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new State(nr, nc, current.moves + 1));
                }
            }
        }

        return -1;
    }
}
