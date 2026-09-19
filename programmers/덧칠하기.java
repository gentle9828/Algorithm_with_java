package programmers;

public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int maxPainted = 0;

        for (int s : section) {
            if (s > maxPainted) {
                count++;
                maxPainted = s + m - 1;
            }
        }

        return count;
    }
}
