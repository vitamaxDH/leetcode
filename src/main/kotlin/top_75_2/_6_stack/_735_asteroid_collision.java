package top_75_2._6_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _735_asteroid_collision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> movingAsteroids = new ArrayDeque<>();
        // find where they conflict
        //  then remove until either side has bigger
        //  if lastOne and the current one has same sig, just add and move to the next.
        // conflict means if the last element is positive and the current one is negative

        moving:
        for (int asteroid : asteroids) {
            if (movingAsteroids.isEmpty()) {
                movingAsteroids.addLast(asteroid);
                continue;
            }
            if (asteroid > 0) {
                movingAsteroids.addLast(asteroid);
            } else {
                if (movingAsteroids.peekLast() < 0) {
                    movingAsteroids.addLast(asteroid);
                } else {
                    int negAbs = Math.abs(asteroid);
                    while (!movingAsteroids.isEmpty() && movingAsteroids.peekLast() <= negAbs) {
                        int lastPos = movingAsteroids.pollLast();
                        if (lastPos == negAbs) {
                            continue moving;
                        } else if (!movingAsteroids.isEmpty() && movingAsteroids.peekLast() < 0) {
                            break;
                        }
                    }
                    if (movingAsteroids.isEmpty() || movingAsteroids.peekLast() < 0) {
                        movingAsteroids.addLast(asteroid);
                    }
                }
            }
        }

        int[] res = new int[movingAsteroids.size()];
        int i = 0;
        for (int asteroid : movingAsteroids) {
            res[i++] = asteroid;
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new _735_asteroid_collision();
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{10, 2, -5})));
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{-2, -1, 1, 2})));
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{-2, -2, 1, -2})));
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{-2, -2, 1, -1})));
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{-2, 2, 1, -2})));
    }
}
