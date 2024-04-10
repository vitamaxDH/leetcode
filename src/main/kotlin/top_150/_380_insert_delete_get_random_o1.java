package top_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class _380_insert_delete_get_random_o1 {
    class RandomizedSet {
        private final ArrayList<Integer> list = new ArrayList<>();
        private final HashMap<Integer, Integer> map = new HashMap<>();

        private Random random = null;

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            list.set(index, list.get(list.size() - 1));
            map.put(list.get(index), index);
            list.remove(list.size() - 1);
            map.remove(val);

            return true;
        }

        public int getRandom() {
            if (random == null) {
                random = new Random();
            }
            return list.get(random.nextInt(list.size()));
        }
    }
}
