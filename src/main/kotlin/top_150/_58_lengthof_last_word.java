package top_150;

public class _58_lengthof_last_word {
    public int lengthOfLastWord(String s) {
        var res = 0;
        var found = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (!found) continue;
                else return res;
            }
            res++;
            if (!found) {
                found = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new _58_lengthof_last_word();
        System.out.println(s.lengthOfLastWord("Hello World"));
        System.out.println(s.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(s.lengthOfLastWord("luffy is still joyboy"));
    }
}
