package programmers;

import java.util.Arrays;

public class 데이터_분석 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIdx = getColumnIndex(ext);
        int sortIdx = getColumnIndex(sort_by);

        int[][] temp = new int[data.length][];
        int count = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i][extIdx] < val_ext) {
                temp[count++] = data[i];
            }
        }

        int[][] answer = Arrays.copyOf(temp, count);

        Arrays.sort(answer, (a, b) -> Integer.compare(a[sortIdx], b[sortIdx]));

        return answer;
    }

    private int getColumnIndex(String target) {
        switch (target) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: throw new IllegalArgumentException("Unknown column: " + target);
        }
    }
}
