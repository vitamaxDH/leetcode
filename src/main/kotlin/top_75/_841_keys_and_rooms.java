package top_75;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class _841_keys_and_rooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        var visited = new HashSet<Integer>();
        Queue<Integer> keys = new ArrayDeque<>();
        for (int key: rooms.get(0)) {
            keys.offer(key);
        }
        visited.add(0);
        while (!keys.isEmpty()) {
            int key = keys.poll();
            if (visited.contains(key)) {
                continue;
            }
            visited.add(key);
            var newKeys = rooms.get(key);
            for (int newKey: newKeys) {
                if (!visited.contains(newKey)) {
                    keys.offer(newKey);
                }
            }
        }
        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        var s = new _841_keys_and_rooms();
        System.out.println(s.canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
        System.out.println(s.canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0))));
    }
}
