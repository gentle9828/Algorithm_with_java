package programmers;

public class 서버_증설_횟수 {
    public int solution(int[] players, int m, int k) {
        int totalAdds = 0;
        int activeServers = 0;
        int[] adds = new int[24];

        for (int i = 0; i < 24; i++) {
            if (i >= k) {
                activeServers -= adds[i - k];
            }

            int requiredServers = players[i] / m;

            if (requiredServers > activeServers) {
                int newServers = requiredServers - activeServers;
                adds[i] = newServers;
                activeServers += newServers;
                totalAdds += newServers;
            }
        }

        return totalAdds;
    }
}
