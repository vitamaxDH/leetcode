package top_150;

import java.util.HashMap;
import java.util.Map;

public class _290_word_pattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> revserdMap = new HashMap<>();
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                var existingWord = map.get(pattern.charAt(i));
                var existingChar = revserdMap.get(existingWord);
                if (pattern.charAt(i) != existingChar) {
                    return false;
                }
                if (!words[i].equals(existingWord)) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i), words[i]);
                revserdMap.put(words[i], pattern.charAt(i));
            }
        }
        return map.size() == revserdMap.size();
    }

    public static void main(String[] args) {
        var s = new _290_word_pattern();
//        System.out.println(s.wordPattern("abba", "dog cat cat dog"));
//        System.out.println(s.wordPattern("abba", "dog cat cat fish"));
//        System.out.println(s.wordPattern("aaaa", "dog cat cat dog"));
//        System.out.println(s.wordPattern("abba", "dog dog dog dog"));
        System.out.println(s.wordPattern("abc", "dog cat dog"));
    }
}
