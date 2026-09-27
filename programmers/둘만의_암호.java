package programmers;

public class 둘만의_암호 {
    public String solution(String s, String skip, int index) {
        boolean[] isSkip = new boolean[26];
        for (char c : skip.toCharArray()) {
            isSkip[c - 'a'] = true;
        }

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            int step = 0;

            while (step < index) {
                c++;
                if (c > 'z') {
                    c = 'a';
                }

                if (!isSkip[c - 'a']) {
                    step++;
                }
            }
            arr[i] = c;
        }

        return new String(arr);
    }
}
