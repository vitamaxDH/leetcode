package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.warmup;

public class Sqrt {

    public int mySqrt(int x) {
        if (x < 2) return x;
        int left = 2;
        int right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long powered = mid * mid;
            if (powered > x) {
                right = mid - 1;
            } else if (powered < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        var s = new Sqrt();
        System.out.println(s.mySqrt(8));
    }
}
