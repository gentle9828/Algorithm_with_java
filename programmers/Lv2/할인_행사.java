package programmers.Lv2;

import java.util.HashMap;
import java.util.Map;

public class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = want.length;

        Map<String, Integer> wantMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            wantMap.put(want[i], i);
        }

        int[] currentCount = new int[n];

        for (int i = 0; i < 10; i++) {
            Integer idx = wantMap.get(discount[i]);
            if (idx != null) {
                currentCount[idx]++;
            }
        }

        if (isMatch(currentCount, number)) {
            answer++;
        }

        for (int i = 10; i < discount.length; i++) {
            Integer removeIdx = wantMap.get(discount[i - 10]);
            if (removeIdx != null) {
                currentCount[removeIdx]--;
            }

            Integer addIdx = wantMap.get(discount[i]);
            if (addIdx != null) {
                currentCount[addIdx]++;
            }

            if (isMatch(currentCount, number)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isMatch(int[] current, int[] target) {
        for (int i = 0; i < current.length; i++) {
            if (current[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
