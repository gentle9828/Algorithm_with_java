package programmers.Lv2;

public class 숫자_변환하기 {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;

        boolean[] visited = new boolean[y + 1];

        int[] qVal = new int[y + 1];
        int[] qCnt = new int[y + 1];
        int head = 0, tail = 0;

        qVal[tail] = y;
        qCnt[tail] = 0;
        tail++;
        visited[y] = true;

        while (head < tail) {
            int curr = qVal[head];
            int cnt = qCnt[head];
            head++;

            int next = curr - n;
            if (next == x) return cnt + 1;
            if (next > x && !visited[next]) {
                visited[next] = true;
                qVal[tail] = next;
                qCnt[tail] = cnt + 1;
                tail++;
            }

            if (curr % 2 == 0) {
                next = curr / 2;
                if (next == x) return cnt + 1;
                if (next > x && !visited[next]) {
                    visited[next] = true;
                    qVal[tail] = next;
                    qCnt[tail] = cnt + 1;
                    tail++;
                }
            }

            if (curr % 3 == 0) {
                next = curr / 3;
                if (next == x) return cnt + 1;
                if (next > x && !visited[next]) {
                    visited[next] = true;
                    qVal[tail] = next;
                    qCnt[tail] = cnt + 1;
                    tail++;
                }
            }
        }

        return -1;
    }
}
