package top_150;

import java.util.*;

public class _49_group_anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        boolean[] seen = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (seen[i]) continue;
            var iWord = strs[i];
            List<String> words = new ArrayList<>();
            words.add(iWord);
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(iWord, strs[j])) {
                    words.add(strs[j]);
                    seen[j] = true;
                }
            }
            res.add(words);
        }
        return res;
    }

    private boolean isAnagram(String s, String t) {
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

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (var str: strs) {
            var chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> anagrams;
            if (!map.containsKey(key)) {
                anagrams = new ArrayList<>();
            } else {
                anagrams = map.get(key);
            }
            anagrams.add(str);
            map.put(key, anagrams);
        }

        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        var s = new _49_group_anagrams();
        for (var anagram : s.groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})) {
            System.out.println(String.join(", ", anagram));
        }
        for (var anagram : s.groupAnagrams2(new String[]{""})) {
            System.out.println(String.join(", ", anagram));
        }
        for (var anagram : s.groupAnagrams2(new String[]{"a"})) {
            System.out.println(String.join(", ", anagram));
        }
        for (var anagram : s.groupAnagrams2(new String[]{"", ""})) {
            System.out.printf("\"%s\"\n", String.join(", ", anagram));
        }
    }
}
