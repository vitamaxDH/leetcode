package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithKDistinctCharacters {
    public int findLength(String str, int k) {
        int maxLength = 0;
        int strLength = str.length();
        for (int i = strLength; i >= 0; i--) {
            for (int j = 0; j < strLength - i + 1; j++) {
                Set<Character> visited = new HashSet<>();
                String substr = str.substring(j, j + i);
                for (int l = 0; l < substr.length(); l++) {
                    char c = substr.charAt(l);
                    visited.add(c);
                    if (visited.size() > k) {
                        break;
                    }
                }
                if (visited.size() <= k) {
                    return i;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        var s = new LongestSubstringWithKDistinctCharacters();
        System.out.println(s.findLength("araaci", 2));
        System.out.println(s.findLength("araaci", 1));
        System.out.println(s.findLength("cbbebi", 3));
        System.out.println(s.findLength("aaaaa", 1));
    }
}
