package top_150;

import java.util.ArrayList;
import java.util.List;

public class _228_summary_ranges {
    public List<String> summaryRanges(int[] nums) {
        var res = new ArrayList<String>();
        var size = 0;
        var start = 0;
        if (nums.length > 0) {
            start = nums[0];
            size = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int prev = nums[i - 1];
            if (cur > 1 + prev) {
                if (size > 1) {
                    res.add(String.format("%d->%d", start, prev));
                } else {
                    res.add(String.valueOf(start));
                }
                start = cur;
                size = 1;
            } else {
                size++;
            }
        }

        if (size > 1) {
            res.add(String.format("%d->%d", start, nums[nums.length - 1]));
        } else if (size == 1) {
            res.add(String.valueOf(start));
        }

        return res;
    }

    public List<String> betterSolution(int[] nums) {
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1])
                i++;

            if (start != nums[i]) {
                al.add(start + "->" + nums[i]);
            } else {
                al.add("" + start);
            }
        }
        return al;
    }

    public static void main(String[] args) {
        var s = new _228_summary_ranges();
//        System.out.println(s.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
//        System.out.println(s.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(s.summaryRanges(new int[]{-2, -1, 1}));
        System.out.println(s.summaryRanges(new int[]{-2147483648, -2147483647, 2147483647}));
    }
}
