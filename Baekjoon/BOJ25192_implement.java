package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class BOJ25192_implement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<String> chats = new HashSet<>();

        int count = 0;

        for (int i = 0; i < N; i++) {
            String chat = br.readLine();
            if (chat.equals("ENTER")) {
                count += chats.size();
                chats.clear();
            } else {
                chats.add(chat);
            }
        }

        count += chats.size();

        bw.write(String.valueOf(count));

        bw.close();
        br.close();
    }
}
