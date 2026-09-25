package programmers;

public class 옹알이2 {
    public int solution(String[] babbling) {
        int answer = 0;

        for (String word : babbling) {
            int len = word.length();
            int i = 0;
            int prev = 0;
            boolean valid = true;

            while (i < len) {
                char c = word.charAt(i);

                if (c == 'a' && i + 2 < len && word.charAt(i + 1) == 'y' && word.charAt(i + 2) == 'a') {
                    if (prev == 1) { valid = false; break; }
                    prev = 1;
                    i += 3;
                }
                else if (c == 'y' && i + 1 < len && word.charAt(i + 1) == 'e') {
                    if (prev == 2) { valid = false; break; }
                    prev = 2;
                    i += 2;
                }
                else if (c == 'w' && i + 2 < len && word.charAt(i + 1) == 'o' && word.charAt(i + 2) == 'o') {
                    if (prev == 3) { valid = false; break; }
                    prev = 3;
                    i += 3;
                }
                else if (c == 'm' && i + 1 < len && word.charAt(i + 1) == 'a') {
                    if (prev == 4) { valid = false; break; }
                    prev = 4;
                    i += 2;
                }
                else {
                    valid = false;
                    break;
                }
            }

            if (valid && i == len) {
                answer++;
            }
        }

        return answer;
    }
}
