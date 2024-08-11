package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.fast_slow_pointers;

public class HappyNumber {
    public static boolean find(int num) {
        int slow = num;
        int fast = num;
        do {
            slow = squareDigits(slow);
            fast = squareDigits(squareDigits(fast));
            if (fast == 1) return true;
        } while (slow != fast);
        return false;
    }

    private static int squareDigits(int num) {
        int cur = num;
        int sum = 0;
        while (cur != 0) {
            int digit = cur % 10;
            sum += digit * digit;
            cur /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(find(23));
//        System.out.println(find(12));
        System.out.println(find(1));
    }
}
