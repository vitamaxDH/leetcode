package top_150;

import java.util.ArrayList;

public class _42_trapping_rain_water {
    public int trap(int[] height) {
        var max = 0;
        var indices = new ArrayList<Integer>();
        var blockSum = 0;
        for (int i = 0; i < height.length; i++) {
            var h = height[i];
            blockSum += h;
            if (h > max) {
                max = h;
                indices.clear();
                indices.add(i);
            } else if (h == max) {
                indices.add(i);
            }
        }

        var leftHighestIdx = indices.get(0);
        var rightHighestIdx = indices.get(indices.size() - 1);
        var squareSize = (rightHighestIdx - leftHighestIdx + 1) * max;

        // from front to the maxIdx
        var submaxIdx = -1;
        for (int i = 0; i < leftHighestIdx; i++) {
            var h = height[i];
            if (h == 0) {
                continue;
            }
            if (submaxIdx == -1 && h > 0) {
                submaxIdx = i;
                continue;
            }

            if (h > height[submaxIdx]) {
                // calculate
                squareSize += (i - submaxIdx) * height[submaxIdx];
                submaxIdx = i;
            }
        }
        if (submaxIdx != -1) {
            squareSize += height[submaxIdx] * (leftHighestIdx - submaxIdx);
        }

        // from end to the maxIdx
        submaxIdx = -1;
        for (int i = height.length - 1; i > rightHighestIdx; i--) {
            var h = height[i];
            if (h == 0) {
                continue;
            }
            if (submaxIdx == -1 && h > 0) {
                submaxIdx = i;
                continue;
            }

            if (h > height[submaxIdx]) {
                // calculate
                squareSize += (submaxIdx - i) * height[submaxIdx];
                submaxIdx = i;
            }
        }
        if (submaxIdx != -1) {
            squareSize += height[submaxIdx] * (submaxIdx - rightHighestIdx);
        }

        return squareSize - blockSum;
    }

    public static void main(String[] args) {
        var s = new _42_trapping_rain_water();
        System.out.println(s.trap(new int[]{ 0,1,0,2,1,0,1,3,2,1,2,1 }));
        System.out.println(s.trap(new int[]{ 4,2,0,3,2,5 }));
    }
}
