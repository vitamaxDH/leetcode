package top_150;

import java.util.HashSet;
import java.util.Set;

public class _202_happy_number {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (!seen.add(n)) return false;
            n = process(n);
        }
        return true;
    }

    private int process(int n) {
        var sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        var s = new _202_happy_number();
        System.out.println(s.isHappy(19));
        System.out.println(s.isHappy(2));
    }
}
