package top_75_2._1768;

public class _merge_strings_alternately {

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int l1 = word1.length();
        int l2 = word2.length();
        int longer = Math.max(l1, l2);
        for (int i = 0; i < longer; i++) {
            if (word1.length() > i) {
                sb.append(word1.charAt(i));
            }
            if (word2.length() > i) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }
}
