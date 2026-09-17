package programmers;

public class 지폐_접기 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int walletMin = Math.min(wallet[0], wallet[1]);
        int walletMax = Math.max(wallet[0], wallet[1]);

        while (!canFit(walletMin, walletMax, bill)) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }

        return answer;
    }

    private boolean canFit(int walletMin, int walletMax, int[] bill) {
        int billMin = Math.min(bill[0], bill[1]);
        int billMax = Math.max(bill[0], bill[1]);

        return billMin <= walletMin && billMax <= walletMax;
    }
}
