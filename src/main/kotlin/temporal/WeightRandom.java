package temporal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WeightRandom {

    List<String> keys;
    int totalWeight;
    int[] prefixSums;
    Random random = new Random();

    public WeightRandom(Map<String, Integer> weights) {
        this.random = new Random();
        this.keys = new ArrayList<>(weights.size());
        this.prefixSums = new int[weights.size()];

        int sum = 0;
        int idx = 0;

        for (Map.Entry<String, Integer> e: weights.entrySet()) {
            int w = e.getValue();
            if (w <= 0) throw new IllegalArgumentException("weight must be positive");
            sum += w;
            prefixSums[idx++] = sum;
            keys.add(e.getKey());
        }
        this.totalWeight = sum;
    }

    String searchLinear() {
        int r = random.nextInt(totalWeight) + 1;
        for (int i = 0; i < prefixSums.length; i++) {
            if (r < prefixSums[i]) {
                return keys.get(i);
            }
        }
        throw new IllegalArgumentException("cannot reach");
    }

    public static void main(String[] args) {
        Map<String, Integer> weights = Map.ofEntries(
            Map.entry("gold", 1),
            Map.entry("silver", 10),
            Map.entry("bronze", 100)
        );
        var wr = new WeightRandom(weights);

        int gCount = 0;
        int sCount = 0;
        int bCount = 0;
        for (int i = 0; i < 110_000; i++) {
            switch (wr.searchLinear()) {
                case "gold" -> gCount++;
                case "silver" -> sCount++;
                case "bronze" -> bCount++;
            }
        }
        System.out.printf("gcount: %d", gCount);
        System.out.printf("scount: %d", sCount);
        System.out.printf("bcount: %d", bCount);
    }
}
