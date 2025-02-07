package top_75_2._1_array_string;

public class _605_can_place_flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            return n == 0 || flowerbed[0] == 0;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) {
                return true;
            }
            int cur = flowerbed[i];
            if (i == 0) {
                int next = flowerbed[i + 1];
                if (cur == 0 && next == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            if (i == flowerbed.length - 1) {
                int prev = flowerbed[i - 1];
                if (cur == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            if (i > 0 && i < flowerbed.length - 1) {
                int prev = flowerbed[i - 1];
                int next = flowerbed[i + 1];
                if (prev == 0 && cur == 0 && next == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        _605_can_place_flowers test = new _605_can_place_flowers();
        System.out.println(test.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(test.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(test.canPlaceFlowers(new int[]{0, 0, 1, 0, 0}, 1));
        System.out.println(test.canPlaceFlowers(new int[]{0, 0, 1, 0, 0}, 2));
    }
}
