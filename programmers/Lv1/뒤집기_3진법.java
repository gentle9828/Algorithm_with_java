package programmers.Lv1;

public class 뒤집기_3진법 {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer = answer * 3 + (n % 3);
            n /= 3;
        }

        return answer;
    }
}
