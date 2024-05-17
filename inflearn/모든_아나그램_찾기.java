package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 모든_아나그램_찾기 {
    public static int solution(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        for(char x : t.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }

        int L = t.length();
        for(int i = 0; i < L - 1; i++) {
            am.put(s.charAt(i), am.getOrDefault(s.charAt(i), 0) + 1);
        }

        int lt = 0;
        for(int rt = L - 1; rt < s.length(); rt++) {
            am.put(s.charAt(rt), am.getOrDefault(s.charAt(rt), 0) + 1);
            if(am.equals(bm)) {
                answer++;
            }
            am.put(s.charAt(lt), am.get(s.charAt(lt)) - 1);
            if(am.get(s.charAt(lt)) == 0) {
                am.remove(s.charAt(lt));
            }
            lt++;
        }


        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String T = br.readLine();

        bw.write(String.valueOf(solution(S, T)));
        bw.flush();

        bw.close();
        br.close();

    }
}
