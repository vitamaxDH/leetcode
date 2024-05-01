package top_75;

import java.util.HashSet;

public class _1456_maximum_number_of_vowels_in_a_substring_of_given_length {
    public int maxVowels(String s, int k) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int vowelCnt = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                vowelCnt++;
            }
        }

        int result = vowelCnt;
        for (int i = k; i + k < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                vowelCnt--;
            }
            if (vowels.contains(s.charAt(i + k))) {
                vowelCnt++;
            }
            result = Math.max(result, vowelCnt);
        }

        return result;
    }

    public static void main(String[] args) {
        var s = new _1456_maximum_number_of_vowels_in_a_substring_of_given_length();
        System.out.println(s.maxVowels("abciiidef", 3));
        System.out.println(s.maxVowels("aeiou", 2));
        System.out.println(s.maxVowels("leetcode", 3));
        System.out.println(s.maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33));
        System.out.println(s.maxVowels("weallloveyou", 7));
    }
}
