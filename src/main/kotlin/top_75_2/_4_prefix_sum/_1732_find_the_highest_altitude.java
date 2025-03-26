package top_75_2._4_prefix_sum;

public class _1732_find_the_highest_altitude {
    public int largestAltitude(int[] gain) {
        int cur = 0;
        int highest = cur;
        for (int j : gain) {
            cur += j;
            highest = Math.max(highest, cur);
        }
        return highest;
    }

    public static void main(String[] args) {
        var s = new _1732_find_the_highest_altitude();
        System.out.println(s.largestAltitude(new int[]{-5, 1, 5, 0, -7}));
    }
}
