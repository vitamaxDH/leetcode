package top_75;

public class _2390_removing_stars_from_a_string {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var s = new _2390_removing_stars_from_a_string();
        System.out.println(s.removeStars("leet**cod*e"));
        System.out.println(s.removeStars("erase*****"));
    }
}
