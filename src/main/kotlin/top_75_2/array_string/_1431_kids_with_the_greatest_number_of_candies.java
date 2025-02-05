package top_75_2.array_string;

import java.util.ArrayList;
import java.util.List;

public class _1431_kids_with_the_greatest_number_of_candies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }

    public static void main(String[] args) {
        _1431_kids_with_the_greatest_number_of_candies test = new _1431_kids_with_the_greatest_number_of_candies();
        System.out.println(test.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(test.kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
        System.out.println(test.kidsWithCandies(new int[]{12, 1, 12}, 10));
    }
}
