package top_75;

public class _1732_findthe_highest_altitude {
    public int largestAltitude(int[] gain) {
        int max = 0, cur = 0;
        for (var al: gain) {
            cur += al;
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        var s = new _1732_findthe_highest_altitude();
        System.out.println(s.largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(s.largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }
}
