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

    public static class _128_longest_consecutive_sequence {
        public int longestConsecutive(int[] nums) {
            // o (2n) -> o(n)
            // should go through all the elements
            // how? which data structure?
            var max = 0;
    //        var cur = 0;
    //        var prevFound = false;
    //        for (int i = 0; i < booleans.length; i++) {
    //            var found = booleans[i];
    //            if (!prevFound && found) {
    //                prevFound = true;
    //                cur = 1;
    //            } else if (prevFound) {
    //                if (found){
    //                    cur++;
    //                } else {
    //                    prevFound = false;
    //                    max = Math.max(max, cur);
    //
    //                }
    //            }
    //        }

            return max;
        }

        public static void main(String[] args) {
            var s = new _128_longest_consecutive_sequence();
            System.out.println(s.longestConsecutive(new int[] {100,4,200,1,3,2}));
            System.out.println(s.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
        }
    }
}
