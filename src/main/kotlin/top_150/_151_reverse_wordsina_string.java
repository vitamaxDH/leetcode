package top_150;

public class _151_reverse_wordsina_string {
    public String reverseWords(String s) {
        var sb = new StringBuilder();
        var isFirst = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                var wordSb = new StringBuilder();
                while (i >= 0 && s.charAt(i) != ' ') {
                    wordSb.insert(0, s.charAt(i));
                    i--;
                }
                if (isFirst) {
                    sb.append(wordSb);
                    isFirst = false;
                } else {
                    sb.append(" ").append(wordSb);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var s = new _151_reverse_wordsina_string();
        System.out.println(s.reverseWords("the sky is blue"));
        System.out.println(s.reverseWords("  hello world  "));
    }
}
