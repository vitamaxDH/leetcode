package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.fast_slow_pointers;

import java.util.HashSet;
import java.util.Set;

public class CycleInACircularArray {
    public boolean loopExists(int[] arr) {
//        Set<Integer> visited = new HashSet<>();
//        int length = arr.length;
//        // ex) length 5
//        // idx -5,-4,-3,-2,-1,0,1,2,3,4,5
//        //      0, 1, 2, 3, 4,0,1,2,3,4,0
//        //      0, 1, 2, 3, 4,0,1,2,3,4,0
//        // if neg: (length + value) % length
//        // if pos: value & length
//
//        while ()
//        return false;
        return false;
    }

    private int getIdx(int value, int len) {
        return (value >= 0 ? len : len + value) & len;
    }

    public static void main(String[] args) {
        var s = new CycleInACircularArray();
        System.out.println(s.loopExists(new int[]{1, 2, -1, 2, 2}));
        System.out.println(s.loopExists(new int[]{2, 2, -1, 2}));
        System.out.println(s.loopExists(new int[]{2, 1, -1, 2}));
    }
}
