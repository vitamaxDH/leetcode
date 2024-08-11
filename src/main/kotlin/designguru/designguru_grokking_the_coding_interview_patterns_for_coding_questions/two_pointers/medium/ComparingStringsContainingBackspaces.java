package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.two_pointers.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class ComparingStringsContainingBackspaces {
    public static boolean compare(String str1, String str2) {
        Deque<Character> s1 = new ArrayDeque<>();
        Deque<Character> s2 = new ArrayDeque<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            if (c1 != '#') {
                s1.add(c1);
            } else if (!s1.isEmpty()) {
                s1.removeLast();
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            char c2 = str2.charAt(i);
            if (c2 != '#') {
                s2.add(c2);
            } else if (!s2.isEmpty()) {
                s2.removeLast();
            }
        }
        StringBuilder b1 = new StringBuilder();
        StringBuilder b2 = new StringBuilder();
        if (s1.size() != s2.size()) return false;
        while (!s1.isEmpty()) {
            b1.append(s1.poll());
            b2.append(s2.poll());
        }

        return b1.compareTo(b2) == 0;
    }

    public static boolean compare2(String str1, String str2) {
        int idx1 = str1.length() - 1;
        int idx2 = str2.length() - 1;

        while (idx1 >= 0 || idx2 >= 0) {
            int i1 = nextIdx(str1, idx1);
            int i2 = nextIdx(str2, idx2);

            if (i1 == -1 && i2 == -1) {
                return true;
            }
            if (i1 == -1 || i2 == -1) {
                return false;
            }
            if (str1.charAt(i1) != str2.charAt(i2)) {
                return false;
            }
            idx1 = i1 - 1;
            idx2 = i2 - 1;
        }
        return true;
    }

    private static int nextIdx(String str, int i) {
        int backspaceCnt = 0;
        while (i >= 0) {
            if (str.charAt(i) == '#') {
                backspaceCnt++;
            } else if (backspaceCnt > 0) {
                backspaceCnt--;
            } else {
                break;
            }
            i--;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(compare2("xy#z", "xzz#"));
        System.out.println(compare2("xy#z", "xyz#"));
        System.out.println(compare2("xp#", "xyz##"));
        System.out.println(compare2("xywrrmp", "xywrrmu#p"));
        System.out.println(compare2("x#y#z#", "x#y#z"));
    }
}
