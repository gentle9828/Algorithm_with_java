package programmers;

import java.util.Stack;

public class 택배상자 {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> auxiliaryBelt = new Stack<>(); // 보조 컨테이너 벨트
        int currentIndex = 0; // 기본 컨테이너 벨트에서 현재 처리해야 하는 상자의 인덱스

        for (int target : order) {
            // 현재 순서의 상자를 기본 컨테이너 벨트에서 찾기
            while (currentIndex < target - 1) {
                auxiliaryBelt.push(++currentIndex);
            }

            // 기본 컨테이너 벨트에 현재 순서의 상자가 있다면 싣기
            if (currentIndex == target - 1) {
                answer++;
                currentIndex++;
            }
            // 보조 컨테이너 벨트의 상단에 현재 순서의 상자가 있는지 확인
            else if (!auxiliaryBelt.isEmpty() && auxiliaryBelt.peek() == target) {
                auxiliaryBelt.pop();
                answer++;
            } else {
                // 현재 순서의 상자를 실을 수 없으면 종료
                break;
            }
        }

        return answer;
    }
}
