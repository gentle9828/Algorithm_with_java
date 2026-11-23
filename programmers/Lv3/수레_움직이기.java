package programmers.Lv3;

public class 수레_움직이기 {
    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    private int n, m;
    private int[][] maze;
    private int rGoalR, rGoalC, bGoalR, bGoalC;
    private int minTurns = Integer.MAX_VALUE;

    public int solution(int[][] maze) {
        this.n = maze.length;
        this.m = maze[0].length;
        this.maze = maze;

        int rr = 0, rc = 0, br = 0, bc = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = maze[i][j];
                if (val == 1) { rr = i; rc = j; }
                else if (val == 2) { br = i; bc = j; }
                else if (val == 3) { rGoalR = i; rGoalC = j; }
                else if (val == 4) { bGoalR = i; bGoalC = j; }
            }
        }

        int rMask = 1 << (rr * m + rc);
        int bMask = 1 << (br * m + bc);

        dfs(rr, rc, br, bc, rMask, bMask, 0);

        return minTurns == Integer.MAX_VALUE ? 0 : minTurns;
    }

    private void dfs(int rr, int rc, int br, int bc, int rMask, int bMask, int turns) {
        if (turns >= minTurns) {
            return;
        }

        boolean rDone = (rr == rGoalR && rc == rGoalC);
        boolean bDone = (br == bGoalR && bc == bGoalC);

        if (rDone && bDone) {
            minTurns = turns;
            return;
        }

        if (turns + 1 >= minTurns) {
            return;
        }

        if (rDone) {
            for (int d = 0; d < 4; d++) {
                int nbr = br + DR[d];
                int nbc = bc + DC[d];

                if (!canMove(nbr, nbc, bMask)) continue;
                if (nbr == rr && nbc == rc) continue;

                dfs(rr, rc, nbr, nbc, rMask, bMask | (1 << (nbr * m + nbc)), turns + 1);
            }
        }

        else if (bDone) {
            for (int d = 0; d < 4; d++) {
                int nrr = rr + DR[d];
                int nrc = rc + DC[d];

                if (!canMove(nrr, nrc, rMask)) continue;
                if (nrr == br && nrc == bc) continue;

                dfs(nrr, nrc, br, bc, rMask | (1 << (nrr * m + nrc)), bMask, turns + 1);
            }
        }

        else {
            for (int rd = 0; rd < 4; rd++) {
                int nrr = rr + DR[rd];
                int nrc = rc + DC[rd];
                if (!canMove(nrr, nrc, rMask)) continue;

                int nextRMask = rMask | (1 << (nrr * m + nrc));

                for (int bd = 0; bd < 4; bd++) {
                    int nbr = br + DR[bd];
                    int nbc = bc + DC[bd];
                    if (!canMove(nbr, nbc, bMask)) continue;

                    if (nrr == nbr && nrc == nbc) continue;
                    if (nrr == br && nrc == bc && nbr == rr && nbc == rc) continue;

                    dfs(nrr, nrc, nbr, nbc, nextRMask, bMask | (1 << (nbr * m + nbc)), turns + 1);
                }
            }
        }
    }

    private boolean canMove(int r, int c, int mask) {
        if (r < 0 || r >= n || c < 0 || c >= m) return false;
        if (maze[r][c] == 5) return false;
        return (mask & (1 << (r * m + c))) == 0;
    }
}
