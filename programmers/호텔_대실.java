package programmers;

public class 호텔_대실 {
    public int solution(String[][] book_time) {
        int[] timeline = new int[1450];

        for (String[] time : book_time) {
            int start = parseTime(time[0]);
            int end = parseTime(time[1]) + 10;

            timeline[start]++;

            if (end < 1450) {
                timeline[end]--;
            }
        }

        int maxRooms = 0;
        int currentRooms = 0;

        for (int i = 0; i < 1450; i++) {
            currentRooms += timeline[i];
            if (currentRooms > maxRooms) {
                maxRooms = currentRooms;
            }
        }

        return maxRooms;
    }

    private int parseTime(String time) {
        int h = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        int m = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        return h * 60 + m;
    }
}
