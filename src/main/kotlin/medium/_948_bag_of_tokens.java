package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _948_bag_of_tokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        // 1. To gain power, need to decrease score
        // 2. To gain score, need to lose power
        if (tokens.length == 0) return 0;
        int curPower = power;
        int score = 0;
        int maxScore = 0;
        Arrays.sort(tokens);

        int l = 0;
        int r = tokens.length - 1;
        int cnt = 0;
        while (l <= r && cnt < tokens.length) {
            cnt++;
            if (score == 0) {
                if (tokens[l] <= curPower) {
                    score++;
                    curPower -= tokens[l];
                    l++;
                    maxScore = Math.max(maxScore, score);
                }
            } else {
                if (tokens[l] <= curPower) {
                    score++;
                    curPower -= tokens[l];
                    l++;
                    maxScore = Math.max(maxScore, score);
                } else {
                    score--;
                    curPower += tokens[r];
                    r--;
                }
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        var s = new _948_bag_of_tokens();
        System.out.println(s.bagOfTokensScore(new int[]{100}, 50));
        System.out.println(s.bagOfTokensScore(new int[]{100, 200}, 150));
        System.out.println(s.bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
        System.out.println(s.bagOfTokensScore(new int[]{48,87,26}, 81));
    }
}
