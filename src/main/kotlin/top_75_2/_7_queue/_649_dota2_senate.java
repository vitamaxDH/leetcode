package top_75_2._7_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class _649_dota2_senate {
    public String predictPartyVictory(String senate) {
        int round = senate.length();
        Queue<Integer> r = new ArrayDeque<>();
        Queue<Integer> d = new ArrayDeque<>();

        for (int i = 0; i < round; i++) {
            if (senate.charAt(i) == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int rIdx = r.poll();
            int dIdx = d.poll();

            if (rIdx < dIdx) {
                r.offer(rIdx + round);
            } else {
                d.offer(dIdx + round);
            }
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        var s = new _649_dota2_senate();
        System.out.println(s.predictPartyVictory("RD"));
        System.out.println(s.predictPartyVictory("RDD"));
        System.out.println(s.predictPartyVictory("DDRRR"));
    }
}
