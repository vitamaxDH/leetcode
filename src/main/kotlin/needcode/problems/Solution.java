package needcode.problems;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sCharCnts = new int[26];
        int[] tCharCnts = new int[26];

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            char sChar = sChars[i];
            char tChar = tChars[i];
            sCharCnts[sChar - 'a']++;
            tCharCnts[tChar - 'a']++;
        }
        for (int i = 0; i < sCharCnts.length; i++) {
            if (sCharCnts[i] != tCharCnts[i]) return false;
        }
        return true;
    }
}

