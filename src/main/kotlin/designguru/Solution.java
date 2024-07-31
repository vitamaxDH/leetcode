package designguru;

class Solution {
    public int mySqrt(int x) {
        if (x < 2)
            return x; // return x if it is 0 or 1
        int left = 2;
        int right = x / 2;
        int pivot;
        long num;
        while (left < right) {
            pivot = left + (right - left) / 2;
            num = (long) pivot * pivot;
            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }
        return right;
    }

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.mySqrt(8));
//        System.out.println(s.mySqrt(3));
//        System.out.println(s.mySqrt(1));
//        System.out.println(s.mySqrt(2147395600));
    }
}
