package programmers.Lv2;

public class 괄호_회전하기 {
    public int solution(String s) {
        int n = s.length();

        if (n % 2 != 0) {
            return 0;
        }

        int balance = 0;
        int minBalance = 0;
        int minIdx = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                balance++;
            } else {
                balance--;
                if (balance < minBalance) {
                    minBalance = balance;
                    minIdx = i;
                }
            }
        }

        if (balance != 0) {
            return 0;
        }

        int start = (minIdx + 1) % n;
        char[] stack = new char[n];
        int top = 0;
        int validRotations = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt((start + i) % n);

            if (c == '(') {
                stack[top++] = ')';
            } else if (c == '[') {
                stack[top++] = ']';
            } else if (c == '{') {
                stack[top++] = '}';
            } else {
                if (top == 0 || stack[--top] != c) {
                    return 0;
                }

                if (top == 0) {
                    validRotations++;
                }
            }
        }

        return top == 0 ? validRotations : 0;
    }
}
