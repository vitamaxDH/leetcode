package codesignal;

public class DepositProfit {
    int solution(int deposit, int rate, int threshold) {
        double balance = deposit;
        int years = 0;
        while(true) {
            years++;
            balance = (balance * (100 + rate)) / 100;
            if (balance >= threshold) {
                break;
            }
        }

        return years;
    }

    public static void main(String[] args) {
        var s = new DepositProfit();
        System.out.println(s.solution(100, 20, 170));
    }
}
