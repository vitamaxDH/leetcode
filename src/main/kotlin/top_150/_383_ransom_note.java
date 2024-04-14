package top_150;

import java.util.HashMap;

public class _383_ransom_note {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        var ranMap = new HashMap<Character, Integer>();
        var magMap = new HashMap<Character, Integer>();

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (ranMap.containsKey(c)) {
                ranMap.put(c, ranMap.get(c) + 1);
            } else {
                ranMap.put(c, 1);
            }
        }

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (magMap.containsKey(c)) {
                magMap.put(c, magMap.get(c) + 1);
            } else {
                magMap.put(c, 1);
            }
        }

        for (var entry: ranMap.entrySet()) {
            if (!magMap.containsKey(entry.getKey())) return false;
            var count = entry.getValue();
            if (count > magMap.get(entry.getKey())) return false;
        }

        return true;
    }

    // Optimal solution
    /**
     *  public boolean canConstruct(String ransomNote, String magazine) {
     *         if (ransomNote.length() > magazine.length()) return false;
     *         int[] alphabets_counter = new int[26];
     *
     *         for (char c : magazine.toCharArray())
     *             alphabets_counter[c-'a']++;
     *
     *         for (char c : ransomNote.toCharArray()){
     *             if (alphabets_counter[c-'a'] == 0) return false;
     *             alphabets_counter[c-'a']--;
     *         }
     *         return true;
     *     }
     * @param args
     */

    public static void main(String[] args) {
        var s = new _383_ransom_note();
        System.out.println(s.canConstruct("a", "b"));
        System.out.println(s.canConstruct("aa", "ab"));
        System.out.println(s.canConstruct("aa", "aab"));
    }
}
