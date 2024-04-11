package top_150;

public class _11_container_with_most_water {
    public int maxArea(int[] height) {
        var size = 0;
        var l = 0;
        var r = height.length - 1;
        while (l < r) {
            var leftLine = height[l];
            var rightLine = height[r];
            size = Math.max(size, (r - l) * Math.min(leftLine, rightLine));
            if (leftLine > rightLine) {
                r--;
            } else {
                l++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        var s = new _11_container_with_most_water();
        System.out.println(s.maxArea(new int[] { 1,8,6,2,5,4,8,3,7 }));
        System.out.println(s.maxArea(new int[] { 1, 1 }));
    }
}
