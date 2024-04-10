package top_150;

public class _125_valid_palindrome {
    public boolean isPalindrome(String s) {
        var sb = new StringBuilder();
        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if ('A' <= c && c <= 'Z') {
                sb.append(Character.toLowerCase(c));
            } else if ('a' <= c && c <= 'z' || '0' <= c && c <= '9') {
                sb.append(c);
            }
        }
        var lowered = sb.toString();
        var l = 0;
        var r = lowered.length() - 1;
        while (l < r) {
            if (lowered.charAt(l) != lowered.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        var s = new _125_valid_palindrome();
//        System.out.println(s.isPalindrome("ABA"));
//        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(s.isPalindrome("race a car"));
    }
}
