package medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class _1717_maximum_score_from_removing_substrings {
    public int maximumGain(String s, int x, int y) {
        if (s.length() == 1) return 0;
        if (s.length() == 2) {
            return Math.max(x, y);
        }
        char[] chars = s.toCharArray();
        int result = 0;
        int aLast = 0;
        int max = 0;
        int min = 0;
        String maxStr = null;
        char[] minCArray = new char[2];

        if (x > y) {
            max = x;
            maxStr = "ab";
            min = y;
            minCArray = "ba".toCharArray();
        } else {
            max = y;
            maxStr = "ba";
            min = x;
            minCArray = "ab".toCharArray();
        }

        int lastIdxInQueue = 0;
        Queue<Character> q = new ArrayDeque<>();
        for (int i = 0; i < chars.length - 1; i++) {
            char c1 = chars[i];
            char c2 = chars[i + 1];
            if (("" + c1 + c2).equals(maxStr)) {
                result += max;
                i++;
            } else {
                if (c1 == 'a' || c1 == 'b' && lastIdxInQueue < i) {
                    q.add(c1);
                    lastIdxInQueue = i;
                }
                if (c2 == 'a' || c2 == 'b' && lastIdxInQueue < i + 1) {
                    q.add(c2);
                    lastIdxInQueue = i + 1;
                }
            }
        }

        Character prevChar = null;
        while (!q.isEmpty()) {
            Character polled = q.poll();
            System.out.printf("polled: %s\n", polled);
        }

        return result;
    }

    public static void main(String[] args) {
        var s = new _1717_maximum_score_from_removing_substrings();
        System.out.println(s.maximumGain("cdbcbbaaabab", 4, 5));
//        System.out.println(s.maximumGain("aabbaaxybbaabb", 5, 4));
    }
}
