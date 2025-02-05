package top_75_2.array_string;

public class _1071_greatest_common_divisor_of_strings {
    public String gcdOfStrings(String str1, String str2) {
        return betterSolution(str1, str2);
//        int l1 = str1.length();
//        int l2 = str2.length();
//        int gcd = gcd(l1, l2);
//        if (l1 == l2) {
//            if (str1.equals(str2)) {
//                return str1;
//            } else {
//                return "";
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < gcd; i++) {
//            char c1 = str1.charAt(i);
//            char c2 = str2.charAt(i);
//            if (c1 != c2) {
//                return "";
//            }
//            sb.append(c1);
//        }
//
//        String commStr = sb.toString();
//        if (l1 > gcd && !str1.replace(commStr, "").isEmpty()) {
//            return "";
//        }
//        if (l2 > gcd && !str2.replace(commStr, "").isEmpty()) {
//            return "";
//        }
//
//        return commStr;
    }

    public String betterSolution(String str1, String str2) {
        boolean hasGcd = (str1 + str2).equals(str2 + str1);
        if (hasGcd) {
            int l1 = str1.length();
            int l2 = str2.length();
            String shorter = l1 > l2 ? str2 : str1;
            int gcd = gcd(l1, l2);
            return shorter.substring(0, gcd);
        } else {
            return "";
        }
    }

    public int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        _1071_greatest_common_divisor_of_strings test = new _1071_greatest_common_divisor_of_strings();
        System.out.println(test.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(test.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(test.gcdOfStrings("LEET", "CODE"));
        System.out.println(test.gcdOfStrings("ABCDEF", "ABC"));
        System.out.println(test.gcdOfStrings("AA", "A"));
        System.out.println(test.gcdOfStrings("ABABAB", "ABAB"));
    }
}
