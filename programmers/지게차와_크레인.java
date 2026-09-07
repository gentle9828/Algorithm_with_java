package programmers;

import java.util.*;

public class 지게차와_크레인 {
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();

        char[][] grid = new char[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(grid[i], '.');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int remainingContainers = n * m;

        for (String req : requests) {
            char target = req.charAt(0);

            if (req.length() == 1) {
                List<int[]> toRemove = new ArrayList<>();
                boolean[][] visited = new boolean[n + 2][m + 2];
                Queue<int[]> q = new LinkedList<>();

                q.offer(new int[]{0, 0});
                visited[0][0] = true;

                while (!q.isEmpty()) {
                    int[] curr = q.poll();
                    int r = curr[0];
                    int c = curr[1];

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr >= 0 && nr < n + 2 && nc >= 0 && nc < m + 2 && !visited[nr][nc]) {
                            if (grid[nr][nc] == '.') {
                                visited[nr][nc] = true;
                                q.offer(new int[]{nr, nc});
                            } else if (grid[nr][nc] == target) {
                                visited[nr][nc] = true;
                                toRemove.add(new int[]{nr, nc});
                            }
                        }
                    }
                }

                for (int[] pos : toRemove) {
                    grid[pos[0]][pos[1]] = '.';
                }
                remainingContainers -= toRemove.size();

            } else {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (grid[i][j] == target) {
                            grid[i][j] = '.';
                            remainingContainers--;
                        }
                    }
                }
            }
        }

        return remainingContainers;
    }
}
