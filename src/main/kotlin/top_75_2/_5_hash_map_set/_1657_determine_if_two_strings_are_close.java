package top_75_2._5_hash_map_set;

import java.util.Arrays;

public class _1657_determine_if_two_strings_are_close {
    public boolean closeStrings(String word1, String word2) {
        // 1. if they have the same lengths
        if (word1.length() != word2.length()) return false;

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            cnt1[word1.charAt(i) - 'a']++;
            cnt2[word2.charAt(i) - 'a']++;
        }

        // 2. check if unique character exists
        //  - this guarantees both words have the identical character sets.
        for (int i = 0; i < cnt1.length; i++) {
            if (cnt1[i] > 0 ^ cnt2[i] > 0) return false;
        }

        Arrays.sort(cnt1);
        Arrays.sort(cnt2);

        // 3. check the count sets are identical
        return Arrays.equals(cnt1, cnt2);











//        if (word1.length() != word2.length()) return false;
//
//        int[] charCount1 = new int[26];
//        int[] charCount2 = new int[26];
//
//        for (int i = 0; i < word1.length(); i++) {
//            charCount1[word1.charAt(i) - 'a']++;
//        }
//
//        for (int i = 0; i < word2.length(); i++) {
//            charCount2[word2.charAt(i) - 'a']++;
//        }
//
//        // There shouldn't be any different characters.
//        for (int i = 0; i < 26; i++) {
//            if (charCount1[i] > 0 ^ charCount2[i] > 0) return false;
//        }
//
//        Arrays.sort(charCount1);
//        Arrays.sort(charCount2);
//
//        return Arrays.equals(charCount1, charCount2);
    }

    public static void main(String[] args) {
        var s = new _1657_determine_if_two_strings_are_close();
        System.out.println(s.closeStrings("abc", "bca"));
        System.out.println(s.closeStrings("a", "aa"));
        System.out.println(s.closeStrings("cabbba", "abbccc"));
        System.out.println(s.closeStrings("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff"));
    }
}
