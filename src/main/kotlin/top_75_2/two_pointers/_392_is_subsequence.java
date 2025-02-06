package top_75_2.two_pointers;

public class _392_is_subsequence {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength > tLength) return false;
        else if (sLength == 0) return true;
        int sIdx = 0;
        for (int i = 0; i < tLength; i++) {
            if (s.charAt(sIdx) == t.charAt(i)) {
                sIdx++;
            }
        }
        return sIdx == sLength;
    }

    public static void main(String[] args) {
        _392_is_subsequence test = new _392_is_subsequence();
//        System.out.println(test.isSubsequence("abc", "ahbgdc"));
//        System.out.println(test.isSubsequence("axc", "ahbgdc"));
        System.out.println(test.isSubsequence("", ""));
    }
}
