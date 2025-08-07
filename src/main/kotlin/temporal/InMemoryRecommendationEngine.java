package temporal;

import java.util.*;

public class InMemoryRecommendationEngine {

    Map<String, Map<String, Integer>> itemCountPurchasedAlong = new HashMap<>();

    void recordPurchaseEvent(String[] items) {
        for (int i = 0; i < items.length; i++) {
            var item = items[i];
            var countsByItem = itemCountPurchasedAlong.getOrDefault(item, new HashMap<>());
            for (int j = 0; j < items.length; j++) {
                if (i == j) continue;
                String another = items[j];
                var countByAnother = countsByItem.getOrDefault(another, 0);
                countsByItem.put(another, countByAnother + 1);
            }
            itemCountPurchasedAlong.put(item, countsByItem);
        }
    }

    String[] getTopNRecommendations(String item, int n) {
        if (!itemCountPurchasedAlong.containsKey(item)) {
            System.out.printf("item: %s not found", item);
            return new String[]{};
        }
        var countsByItem = itemCountPurchasedAlong.getOrDefault(item, new HashMap<>());
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        heap.addAll(countsByItem.entrySet());
        List<String> buffer = new ArrayList<>();
        while (!heap.isEmpty() && buffer.size() < n) {
            buffer.add(heap.poll().getKey());
        }
        System.out.println(String.join(", ", buffer));
        return buffer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        var imre = new InMemoryRecommendationEngine();
        imre.recordPurchaseEvent(new String[]{"A", "B", "C"});
        imre.recordPurchaseEvent(new String[]{"A", "B"});
        imre.recordPurchaseEvent(new String[]{"A", "D"});
        imre.recordPurchaseEvent(new String[]{"B", "C", "E"});
        imre.recordPurchaseEvent(new String[]{"C", "E"});

        imre.getTopNRecommendations("A", 5); // → ["B", "C", "D"]
        // A와 함께: B=2, C=1, D=1 → 총 3개 뿐이므로 ["B","C","D"]

        imre.getTopNRecommendations("B", 1); //  → ["A"]
        // B와 함께: A=2, C=2, E=1 → A,C 동점 → 알파벳순 첫 번째 "A"

        imre.getTopNRecommendations("C", 2); // → ["B", "E"]
        // C와 함께: B=2, E=2, A=1 → B,E 동점 → 알파벳순 ["B","E"]

        imre.getTopNRecommendations("D", 2); //→ ["A"]
        // D와 함께: A=1 → 나머지 없으니 ["A"]

        imre.getTopNRecommendations("E", 1); // → ["C"]
        // E와 함께: C=2, B=1 → 최댓값 C

        imre.getTopNRecommendations("X", 3); // → []
        // X가 등장한 이벤트가 없으므로 빈 배열 반환
    }
}
