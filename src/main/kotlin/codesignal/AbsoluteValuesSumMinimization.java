package codesignal;

public class AbsoluteValuesSumMinimization {
    int solution(int[] a) {
        if (a.length == 1) return a[0];
        if (a.length == 2) return Math.min(a[0], a[1]);

        // Naive Approach
        // calculate all the element's sum
        int min = Integer.MAX_VALUE;
        int val = -1;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int num: a) {
                sum += num;
            }
            if (min > sum) {
                min = sum;
                val = a[i];
            }
        }
        // return a[a.length >>> 1];
        return val;
    }

    public static void main(String[] args) {
        var s = new AbsoluteValuesSumMinimization();
        System.out.println(s.solution(new int[]{2,4,7}));
    }

}
