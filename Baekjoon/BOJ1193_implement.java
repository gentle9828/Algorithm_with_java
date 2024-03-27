package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1193_implement {
    public static String solution(int X) {
        String answer = "";
        int count = 1;
        int countSum = 0;

        while (true) {
            if (X <= count + countSum) {
                if (count % 2 == 1) {
                    answer = (count - (X - countSum - 1)) + "/" + (X - countSum);
                    break;
                }

                else {
                    answer = (X - countSum) + "/" + (count - (X - countSum - 1));
                    break;
                }

            } else {
                countSum += count;
                count++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());

        bw.write(solution(X));

        bw.close();
        br.close();

    }
}
