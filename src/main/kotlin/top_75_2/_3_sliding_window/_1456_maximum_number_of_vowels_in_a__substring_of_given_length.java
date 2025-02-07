package top_75_2._3_sliding_window;

public class _1456_maximum_number_of_vowels_in_a__substring_of_given_length {
    public int maxVowels(String s, int k) {
        int curCnt = 0;
        for (int i = 0; i < k; i++) {
            curCnt += isVowel(s.charAt(i));
        }
        int maxCnt = curCnt;
        for (int i = 0; i < s.length() - k; i++) {
            curCnt = curCnt - isVowel(s.charAt(i)) + isVowel(s.charAt(i + k));
            maxCnt = Math.max(maxCnt, curCnt);
        }
        return maxCnt;
    }

    private int isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> 1;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        _1456_maximum_number_of_vowels_in_a__substring_of_given_length test = new _1456_maximum_number_of_vowels_in_a__substring_of_given_length();
        System.out.println(test.maxVowels("abciiidef", 3));
        System.out.println(test.maxVowels("aeiou", 2));
        System.out.println(test.maxVowels("weallloveyou", 7));
    }
}
