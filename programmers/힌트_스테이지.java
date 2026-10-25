package programmers;

public class 힌트_스테이지 {
    private int n;
    private int[][] cost;
    private int[][] hint;
    private int minTotalCost = Integer.MAX_VALUE;

    public int solution(int[][] cost, int[][] hint) {
        this.n = cost.length;
        this.cost = cost;
        this.hint = hint;

        dfs(0, 0, new int[n]);

        return minTotalCost;
    }

    private void dfs(int stage, int currentCost, int[] hintsCount) {
        int usableHints = Math.min(hintsCount[stage], n - 1);
        int nextCost = currentCost + cost[stage][usableHints];

        if (nextCost >= minTotalCost) {
            return;
        }

        if (stage == n - 1) {
            minTotalCost = nextCost;
            return;
        }

        dfs(stage + 1, nextCost, hintsCount);

        int costWithBundle = nextCost + hint[stage][0];

        if (costWithBundle < minTotalCost) {

            for (int i = 1; i < hint[stage].length; i++) {
                hintsCount[hint[stage][i] - 1]++;
            }

            dfs(stage + 1, costWithBundle, hintsCount);

            for (int i = 1; i < hint[stage].length; i++) {
                hintsCount[hint[stage][i] - 1]--;
            }
        }
    }
}
