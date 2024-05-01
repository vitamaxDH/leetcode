package top_75;

public class _136_single_number {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        var s = new _136_single_number();
        System.out.println(s.singleNumber(new int[]{2,2,1}));
        System.out.println(s.singleNumber(new int[]{4,1,2,1,2}));
    }
}
