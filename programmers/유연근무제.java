package programmers;

public class 유연근무제 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int successCount = 0;
        int n = schedules.length;

        for (int i = 0; i < n; i++) {
            int limitTime = toMinutes(schedules[i]) + 10;
            boolean isDiligent = true;

            for (int j = 0; j < 7; j++) {
                int currentDay = (startday - 1 + j) % 7 + 1;

                if (currentDay == 6 || currentDay == 7) {
                    continue;
                }

                if (toMinutes(timelogs[i][j]) > limitTime) {
                    isDiligent = false;
                    break;
                }
            }

            if (isDiligent) {
                successCount++;
            }
        }

        return successCount;
    }

    private int toMinutes(int time) {
        int hours = time / 100;
        int minutes = time % 100;
        return hours * 60 + minutes;
    }
}
