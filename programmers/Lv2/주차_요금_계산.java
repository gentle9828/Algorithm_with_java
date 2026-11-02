package programmers.Lv2;

import java.util.Arrays;

public class 주차_요금_계산 {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        int[] inTime = new int[10000];
        int[] totalTime = new int[10000];
        boolean[] hasRecord = new boolean[10000];

        Arrays.fill(inTime, -1);

        int carCount = 0;

        for (String record : records) {
            int h = (record.charAt(0) - '0') * 10 + (record.charAt(1) - '0');
            int m = (record.charAt(3) - '0') * 10 + (record.charAt(4) - '0');
            int time = h * 60 + m;

            int car = (record.charAt(6) - '0') * 1000
                    + (record.charAt(7) - '0') * 100
                    + (record.charAt(8) - '0') * 10
                    + (record.charAt(9) - '0');

            if (!hasRecord[car]) {
                hasRecord[car] = true;
                carCount++;
            }

            if (record.charAt(11) == 'I') {
                inTime[car] = time;
            } else {
                totalTime[car] += (time - inTime[car]);
                inTime[car] = -1;
            }
        }

        int[] answer = new int[carCount];
        int idx = 0;

        for (int i = 0; i < 10000; i++) {
            if (hasRecord[i]) {
                if (inTime[i] != -1) {
                    totalTime[i] += (1439 - inTime[i]);
                }

                int t = totalTime[i];
                int fee = baseFee;

                if (t > baseTime) {
                    fee += ((t - baseTime + unitTime - 1) / unitTime) * unitFee;
                }

                answer[idx++] = fee;
            }
        }

        return answer;
    }
}
