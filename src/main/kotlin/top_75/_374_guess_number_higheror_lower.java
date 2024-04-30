package top_75;

public class _374_guess_number_higheror_lower {
    public int guessNumber(int n) {
        if (guess(n) == 0) return n;
        int min = 0;
        int cur = n;
        while (true) {
            int med = (min + cur) >>> 1;
            int guess = guess(med);
            if (guess == 1) {
                min = med;
            } else if (guess == -1)  {
                cur = med;
            } else {
                return med;
            }
        }
    }

    private int guess(int n) {
        return Integer.compare(6, n);
    }

    public static void main(String[] args) {
        var s = new _374_guess_number_higheror_lower();
        System.out.println(s.guessNumber(10));
//        System.out.println(s.guessNumber(1000));
    }
}
