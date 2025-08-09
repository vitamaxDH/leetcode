package top_150;

public class _242_valid_anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sVisited = new int[26];
        int[] tVisited = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sVisited[s.charAt(i) - 'a']++;
            tVisited[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < sVisited.length; i++) {
            if (sVisited[i] != tVisited[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        var s = new _242_valid_anagram();
        System.out.println(s.isAnagram("anagram", "nagaram"));
        System.out.println(s.isAnagram("rat", "car"));
    }
}
