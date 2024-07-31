package top_150;

import java.util.Arrays;

public class _135_candy {
    public int candy(int[] ratings) {
        var res = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) {
                res[i] = 1;
                continue;
            }
            // 1,2,87,87,87,2,1
            // 1
            // 1,2
            // 1,2,3
            // 1,2,3,1
            // 1,2,3,1,1
            // 1,2,3,1,1,1
            // 1,2,3,1,2,1
            // 1,2,3,1,2,1,1
            // 1,2,3,1,2,2,1
            // 1,2,3,1,3,2,1
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            } else if (ratings[i] == ratings[i - 1]) {
                res[i] = 1;
            } else {
                res[i] = 1;
                var lIdx = i;
                while (lIdx >= 1 && ratings[lIdx] < ratings[lIdx - 1] && res[lIdx] >= res[lIdx - 1]) {
                    res[lIdx - 1] = res[lIdx - 1] + 1;
                    lIdx--;
                }
            }
        }
        return Arrays.stream(res).sum();
    }

    public static void main(String[] args) {
        var s = new _135_candy();
//        System.out.println(s.candy(new int[]{1,0,2}));
//        System.out.println(s.candy(new int[]{1,2,2}));
//        System.out.println(s.candy(new int[]{1,3,2,2,1}));
        System.out.println(s.candy(new int[]{1,2,87,87,87,2,1}));
    }
}
