package top_150;

public class _392_is_subsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return false;
        var idx = 0;
        for (int i = 0; i < t.length(); i++) {
            var c = t.charAt(i);
            if (s.charAt(idx) == c) {
                if (++idx == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var s = new _392_is_subsequence();
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
        System.out.println(s.isSubsequence("axc", "ahbgdc"));
    }
}
