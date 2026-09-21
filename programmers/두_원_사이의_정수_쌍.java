package programmers;

public class 두_원_사이의_정수_쌍 {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {
            long maxY = (long) Math.sqrt(1L * r2 * r2 - 1L * x * x);

            long minY = 0;
            if (x < r1) {
                minY = (long) Math.ceil(Math.sqrt(1L * r1 * r1 - 1L * x * x));
            }

            answer += (maxY - minY + 1);
        }

        return answer * 4;
    }
}
