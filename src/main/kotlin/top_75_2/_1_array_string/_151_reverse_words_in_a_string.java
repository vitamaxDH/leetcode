package top_75_2._1_array_string;

public class _151_reverse_words_in_a_string {
    public String reverseWords(String s) {
        return betterSolution(s);
//        String[] strs = s.trim().split("\\s+");
//        if (strs.length == 1) {
//            return strs[0];
//        }
//        for (int i = 0; i < strs.length / 2; i++) {
//            String t = strs[i];
//            strs[i] = strs[strs.length - i - 1];
//            strs[strs.length - i - 1] = t;
//        }
//        return String.join(" ", strs);
    }

    public String betterSolution(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            // 1. find a word
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            StringBuilder subSb = new StringBuilder();
            while (i < s.length() && s.charAt(i) != ' ') {
                subSb.append(s.charAt(i));
                i++;
            }

            // 2. insert
            sb.insert(0, " " + subSb);
        }
        return sb.substring(1);
    }

    public static void main(String[] args) {
        _151_reverse_words_in_a_string test = new _151_reverse_words_in_a_string();
        System.out.println(test.reverseWords("the sky is blue"));
//        System.out.println(test.reverseWords("  hello world  "));
//        System.out.println(test.reverseWords("a good   example"));
//        System.out.println(test.reverseWords("  Bob    Loves  Alice   "));
//        System.out.println(test.reverseWords("Alice does not even like bob"));
    }
}
