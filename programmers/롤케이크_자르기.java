package programmers;

import java.util.HashMap;
import java.util.Map;

public class 롤케이크_자르기 {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> chulsu = new HashMap<>();
        Map<Integer, Integer> brother = new HashMap<>();

        for(int x : topping) {
            chulsu.put(x, chulsu.getOrDefault(x, 0) + 1);
        }

        for(int x : topping) {
            if(chulsu.get(x) - 1 == 0) {
                chulsu.remove(x);
            } else {
                chulsu.put(x, chulsu.get(x) - 1);
            }

            brother.put(x, brother.getOrDefault(x, 0) + 1);

            if(chulsu.size() == brother.size()) {
                answer++;
            }
        }

        return answer;
    }
}
