package programmers.Lv2;

import java.util.Arrays;

public class 무인도_여행 {
    public int[] solution(String[] maps) {
        int rLen = maps.length;
        int cLen = maps[0].length();

        char[][] grid = new char[rLen][];
        for (int i = 0; i < rLen; i++) {
            grid[i] = maps[i].toCharArray();
        }

        int[] answer = new int[rLen * cLen / 2 + 1];
        int count = 0;

        int maxNodes = rLen * cLen;
        int[] qR = new int[maxNodes];
        int[] qC = new int[maxNodes];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (grid[i][j] != 'X') {
                    int sum = 0;
                    int head = 0;
                    int tail = 0;

                    qR[tail] = i;
                    qC[tail] = j;
                    tail++;

                    sum += (grid[i][j] - '0');
                    grid[i][j] = 'X';

                    while (head < tail) {
                        int r = qR[head];
                        int c = qC[head];
                        head++;

                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr >= 0 && nr < rLen && nc >= 0 && nc < cLen && grid[nr][nc] != 'X') {
                                sum += (grid[nr][nc] - '0');
                                grid[nr][nc] = 'X';

                                qR[tail] = nr;
                                qC[tail] = nc;
                                tail++;
                            }
                        }
                    }

                    answer[count++] = sum;
                }
            }
        }

        if (count == 0) {
            return new int[]{-1};
        }

        int[] finalAnswer = Arrays.copyOf(answer, count);
        Arrays.sort(finalAnswer);

        return finalAnswer;
    }
}
