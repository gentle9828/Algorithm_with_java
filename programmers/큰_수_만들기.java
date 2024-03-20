package programmers;

public class 큰_수_만들기 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        int max = 0;
        // number에서 k개의 숫자를 제거한 후 남는 숫자의 길이
        for(int i = 0; i < number.length() - k; i++) {
            max = 0;
            // j는 이전 단계에서 선택된 인덱스 다음부터, 현재 단계에서 선택할 수 있는 범위까지 반복
            for(int j = index; j <= k + i; j++) {
                // 현재 숫자가 이전에 찾은 최대값보다 크면, 최대값을 갱신하고 인덱스를 저장
                if(max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }
            // 최댓값을 결과에 추가
            answer.append(max);
        }
        return answer.toString();
    }
}
