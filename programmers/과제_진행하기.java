package programmers;

import java.util.*;

public class 과제_진행하기 {
    class Task {
        String name;
        int start;
        int playtime;

        public Task(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }

    public String[] solution(String[][] plans) {
        List<Task> tasks = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        for (String[] plan : plans) {
            String[] time = plan[1].split(":");
            int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            int playtime = Integer.parseInt(plan[2]);
            tasks.add(new Task(plan[0], start, playtime));
        }

        tasks.sort(Comparator.comparingInt(t -> t.start));

        Deque<Task> stack = new ArrayDeque<>();

        for (int i = 0; i < tasks.size() - 1; i++) {
            Task current = tasks.get(i);
            Task next = tasks.get(i + 1);

            int timeDiff = next.start - current.start;

            if (current.playtime <= timeDiff) {
                answer.add(current.name);
                int spareTime = timeDiff - current.playtime;

                while (spareTime > 0 && !stack.isEmpty()) {
                    Task paused = stack.pop();
                    if (paused.playtime <= spareTime) {
                        answer.add(paused.name);
                        spareTime -= paused.playtime;
                    } else {
                        paused.playtime -= spareTime;
                        stack.push(paused);
                        break;
                    }
                }
            } else {
                current.playtime -= timeDiff;
                stack.push(current);
            }
        }

        answer.add(tasks.get(tasks.size() - 1).name);

        while (!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }

        return answer.toArray(new String[0]);
    }
}
