package top_75_2._3_sliding_window;

public class _1004_max_consecutive_ones_iii {
    // takeaway: 몇개를 넣고 dynamic 하게 어떻게 다음 1111 그룹까지 확장해서 생각하지 않고
    // 간단하게 window sliding 으로 하나씩 늘리는 방식으로 처리
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int max = 0;
        int zc = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zc++;
            }
            if (zc > k) {
                if (nums[l] == 0) {
                    zc--;
                }
                l++;
            }

            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        _1004_max_consecutive_ones_iii test = new _1004_max_consecutive_ones_iii();
        System.out.println(test.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(test.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println(test.longestOnes(new int[]{1,1,1,0,1,0,0}, 1));
    }







//    public int longestOnes(int[] nums, int k) {
//        int left = 0;          // Left pointer for the sliding window
//        int maxLength = 0;     // To keep track of the maximum window size found
//        int zerosCount = 0;    // Count of zeros in the current window
//
//        // Iterate through the array with 'right' pointer as the window's end
//        for (int right = 0; right < nums.length; right++) {
//            // If we encounter a 0, increase the zeros count
//            if (nums[right] == 0) {
//                zerosCount++;
//            }
//
//            // If the count of zeros exceeds k, shrink the window from the left
//            while (zerosCount > k) {
//                if (nums[left] == 0) {
//                    zerosCount--;
//                }
//                left++; // Move the left pointer rightwards
//            }
//
//            // Update the maximum length. (right - left + 1) is the current window size.
//            maxLength = Math.max(maxLength, right - left + 1);
//        }
//
//        return maxLength;
//    }
}


