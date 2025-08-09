package top_150;

import java.util.HashSet;
import java.util.Set;

public class _3_longest_substring_without_repeating_characters {

    // Sliding window 의 전형적인
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        boolean[] seen = new boolean[128];
        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            // 중복이면 left를 움직여서 중복 해소
            while (seen[c]) {
                seen[s.charAt(left)] = false;
                left++;
            }
            // 이제 c는 윈도우에 없음 → 추가 후 right 확장
            seen[c] = true;
            right++;
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        var s = new _3_longest_substring_without_repeating_characters();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        System.out.println(s.lengthOfLongestSubstring("aab"));
        System.out.println(s.lengthOfLongestSubstring("dvdf"));
    }
}
