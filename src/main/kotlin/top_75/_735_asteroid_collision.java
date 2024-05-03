package top_75;

import java.util.Arrays;
import java.util.Stack;

public class _735_asteroid_collision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.add(asteroid);
            } else {
                int prev = stack.peek();

                if (prev * asteroid > 0) {
                    stack.add(asteroid);
                } else if (prev < 0 && asteroid > 0) {
                    stack.add(asteroid);
                } else {
                    // diff sign
                    int prevAbs = Math.abs(prev);
                    int curAbs = Math.abs(asteroid);
                    boolean curBroken = false;
                    if (prevAbs < curAbs) {
                        while (!stack.isEmpty()) {
                            prev = stack.peek();
                            if (prev * asteroid > 0) break;
                            prevAbs = Math.abs(prev);
                            if (prevAbs < curAbs) {
                                stack.pop();
                            } else if (prevAbs ==curAbs) {
                                stack.pop();
                                curBroken = true;
                                break;
                            } else {
                                curBroken = true;
                                break;
                            }
                        }
                        if (!curBroken) {
                            stack.add(asteroid);
                        }
                    } else if (prevAbs == curAbs) {
                        stack.pop();
                    }
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new _735_asteroid_collision();
//        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{5, 10, -5})));
//        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{8, -8})));
//        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{10, 2, -5})));
//        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{-2, -1, 1, 2})));
//        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{-2, -2, 1, -2})));
//        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{-2, 2, 1, -2})));
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{1, 2, 1, -2})));
    }
}
