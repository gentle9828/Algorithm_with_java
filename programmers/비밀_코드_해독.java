package programmers;

public class 비밀_코드_해독 {
    private int m;
    private int[] qMasks;
    private int[] qAns;
    private int answer = 0;

    public int solution(int n, int[][] q, int[] ans) {
        m = q.length;
        qMasks = new int[m];
        qAns = ans;

        for (int i = 0; i < m; i++) {
            int mask = 0;
            for (int num : q[i]) {
                mask |= (1 << num);
            }
            qMasks[i] = mask;
        }

        dfs(1, n, 0, 0);

        return answer;
    }

    private void dfs(int start, int n, int count, int currentMask) {
        for (int i = 0; i < m; i++) {
            int matches = Integer.bitCount(currentMask & qMasks[i]);
            int remain = 5 - count;

            if (matches > qAns[i] || matches + remain < qAns[i]) {
                return;
            }
        }

        if (count == 5) {
            answer++;
            return;
        }

        if (n - start + 1 < 5 - count) {
            return;
        }

        for (int i = start; i <= n; i++) {
            dfs(i + 1, n, count + 1, currentMask | (1 << i));
        }
    }
}
