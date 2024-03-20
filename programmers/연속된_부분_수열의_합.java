package programmers;

public class 연속된_부분_수열의_합 {
    public int[] solution(int[] sequence, int k) {
        int sum = 0;
        int minLength = Integer.MAX_VALUE; // 찾은 부분 수열 중 최소 길이
        int[] answer = {-1, -1}; // 조건을 만족하는 부분 수열을 찾지 못한 경우
        int lt = 0;

        for (int rt = 0; rt < sequence.length; rt++) {
            sum += sequence[rt];

            // 부분 수열의 합이 k와 같을 때
            while (sum >= k) {
                if (sum == k) {
                    // 현재 부분 수열의 길이가 이전에 찾은 부분 수열의 최소 길이보다 짧거나,
                    // 첫 번째로 찾는 경우 결과를 업데이트
                    if (rt - lt < minLength) {
                        minLength = rt - lt;
                        answer[0] = lt;
                        answer[1] = rt;
                    }
                }
                sum -= sequence[lt++];
            }
        }

        return answer; // 조건을 만족하는 부분 수열의 시작과 끝 인덱스 반환
    }
}
