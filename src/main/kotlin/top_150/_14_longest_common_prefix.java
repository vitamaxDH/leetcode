package top_150;

import java.util.Arrays;
import java.util.Comparator;

public class _14_longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        var shortest = Arrays.stream(strs)
                .min(Comparator.comparingInt(String::length))
                .orElse("")
                .length();
        var sb = new StringBuilder();
        for (int i = 0; i < shortest; i++) {
            var prefix = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != prefix) {
                    return sb.toString();
                }
            }
            sb.append(prefix);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var s = new _14_longest_common_prefix();
        System.out.println(s.longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(s.longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }
}
