package top_150;

import java.util.HashMap;

public class _205_isomorphic_strings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        var map = new HashMap<Character, Character>();
        var checks = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            var sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!map.containsKey(sc)) {
                if (checks[tc - 'a']) {
                    return false;
                }
                map.put(sc, tc);
                checks[tc - 'a'] = true;
            } else {
                var cFromMap = map.get(sc);
                if (cFromMap != tc) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        var s = new _205_isomorphic_strings();
        System.out.println(s.isIsomorphic("egg", "add"));
        System.out.println(s.isIsomorphic("foo", "bar"));
        System.out.println(s.isIsomorphic("paper", "title"));
        System.out.println(s.isIsomorphic("badc", "baba")); // should be false
    }
}
