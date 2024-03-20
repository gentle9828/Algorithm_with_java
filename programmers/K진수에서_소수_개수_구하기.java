package programmers;

public class K진수에서_소수_개수_구하기 {
    public static boolean isPrime(long number) {
        if(number <= 1) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int solution(int n, int k) {
        int answer = 0;
        String changeNumber = Integer.toString(n, k);
        String[] numberDivideByZero = changeNumber.split("0+");

        for(String value : numberDivideByZero) {
            long result = Long.parseLong(value);
            if(isPrime(result)) {
                answer++;
            }
        }

        return answer;
    }
}
