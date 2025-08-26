package topic.queue;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {

    List<Integer> nums;

    public ProductOfNumbers() {
        nums = new ArrayList<>();
    }
    
    public void add(int num) {
        nums.add(num);
    }
    
    public int getProduct(int k) {
        var product = 1;
        var lastIdx = Math.min(nums.size() - k, 0);
        for (int i = nums.size() - 1; i >= lastIdx; i--) {
            product *= nums.get(i);
            if (product == 0) return 0;
        }
        return product;
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        System.out.println(productOfNumbers.getProduct(2)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        System.out.println(productOfNumbers.getProduct(3)); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        System.out.println(productOfNumbers.getProduct(4)); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        System.out.println(productOfNumbers.getProduct(2)); // return 32. The product of the last 2 numbers is 4 * 8 = 32
    }
}
