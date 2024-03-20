package programmers;

public class 삼각_달팽이 {
    // 아래, 오른쪽, 왼쪽 위 대각선 방향으로 이동
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        // n x n 배열을 생성
        int[][] triangle = new int[n][n];
        int v = 1; // 1부터 숫자 시작.
        int x = 0;
        int y = 0;
        int d = 0;

        while(true) {
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 다음 위치가 배열 범위를 벗어나거나 이미 숫자가 채워진 경우, 방향 변경.
            if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                // 다시 계산한 위치가 여전히 범위를 벗어나거나 숫자가 채워져 있으면 종료.
                if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                    break;
                }
            }
            x = nx;
            y = ny;
        }

        // 삼각형 배열에 채워진 숫자들을 1차원 배열로 변환.
        int[] answer = new int[v - 1];
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }
}
