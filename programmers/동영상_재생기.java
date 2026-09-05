package programmers;

public class 동영상_재생기 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = toSeconds(video_len);
        int currentPos = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);

        if (currentPos >= opStart && currentPos <= opEnd) {
            currentPos = opEnd;
        }

        for (String command : commands) {
            if (command.equals("prev")) {
                currentPos -= 10;
                if (currentPos < 0) {
                    currentPos = 0;
                }
            } else if (command.equals("next")) {
                currentPos += 10;
                if (currentPos > videoLen) {
                    currentPos = videoLen;
                }
            }

            if (currentPos >= opStart && currentPos <= opEnd) {
                currentPos = opEnd;
            }
        }

        return toStringFormat(currentPos);
    }

    private int toSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    private String toStringFormat(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
