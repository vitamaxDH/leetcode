package top_150;

public class _28_findthe_indexofthe_first_occurrenceina_string {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            var notMatching = false;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    notMatching = true;
                    break;
                }
            }
            if (!notMatching) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        var s = new _28_findthe_indexofthe_first_occurrenceina_string();
        System.out.println(s.strStr("sasadbutsad", "sad"));
        System.out.println(s.strStr("leetcode", "leeto"));
    }
}
