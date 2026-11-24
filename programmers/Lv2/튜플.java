package programmers.Lv2;

public class 튜플 {
    public int[] solution(String s) {
        int[] count = new int[100001];
        int[] uniqueNums = new int[501];
        int uniqueCount = 0;

        int len = s.length();
        int num = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (num > 0) {
                if (count[num] == 0) {
                    uniqueNums[uniqueCount++] = num;
                }
                count[num]++;
                num = 0;
            }
        }

        int[] answer = new int[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            int val = uniqueNums[i];
            answer[uniqueCount - count[val]] = val;
        }

        return answer;
    }
}
