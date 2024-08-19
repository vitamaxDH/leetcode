package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.slidingwindow;

import java.util.HashSet;
import java.util.Set;

// 9 m 30 s
public class FruitsIntoBaskets {
    public int findLength(char[] arr) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            Set<Character> types = new HashSet<>();
            int size = 0;
            int idx = i;
            while (idx < arr.length) {
                char c = arr[idx];
                types.add(c);
                if (types.size() > 2) break;
                size++;
                idx++;
            }
            maxLength = Math.max(maxLength, size);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        var s = new FruitsIntoBaskets();
        System.out.println(s.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println(s.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
        System.out.println(s.findLength(new char[] { 'A' }));
    }
}
