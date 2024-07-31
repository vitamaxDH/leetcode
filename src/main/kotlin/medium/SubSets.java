package medium;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<int[]> subsets = getSubsets(nums);

        for (int[] subset : subsets) {
            System.out.print("[");
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }
    }

    public static List<int[]> getSubsets(int[] nums) {
        List<int[]> subsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void generateSubsets(int[] nums, int index, List<Integer> current, List<int[]> subsets) {
        if (index == nums.length) {
            int[] subset = new int[current.size()];
            for (int i = 0; i < current.size(); i++) {
                subset[i] = current.get(i);
            }
            subsets.add(subset);
            return;
        }

        generateSubsets(nums, index + 1, current, subsets);

        current.add(nums[index]);
        generateSubsets(nums, index + 1, current, subsets);
        current.remove(current.size() - 1);
    }
}
