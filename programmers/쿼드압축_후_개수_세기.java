package programmers;

public class 쿼드압축_후_개수_세기 {
    // 0과 1의 개수를 저장하는 배열
    private static int[] answer = new int[2];

    // 영역이 모두 같은 값으로 이루어져 있는지 확인
    public boolean isPossibleCombine(int x, int y, int size, int[][] arr) {
        int value = arr[x][y];
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(value != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 쿼드 트리 방식으로 압축
    public void compress(int x, int y, int size, int[][] arr) {
        if(isPossibleCombine(x, y, size, arr)) {
            answer[arr[x][y]]++;
            return;
        }

        // 영역을 4등분해서 재귀적으로 압축
        int newSize = size / 2;
        compress(x, y, newSize, arr);
        compress(x + newSize, y, newSize, arr);
        compress(x, y + newSize, newSize, arr);
        compress(x + newSize, y + newSize, newSize, arr);
    }

    public int[] solution(int[][] arr) {
        compress(0, 0, arr.length, arr);

        return answer;
    }
}
