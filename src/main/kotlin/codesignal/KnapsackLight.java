package codesignal;

public class KnapsackLight {
    int solution(int value1, int weight1, int value2, int weight2, int maxW) {
        // if they hav ethe same weight, I can return the value right away
        if (weight1 == weight2) {
            return (maxW / weight1) * Math.max(value1, value2);
        }
        // Calculate the first value
        // Balance the numbers of those objects by subtracting one by one of object 1 and plus one by one of object 2

        // 1. First value (greedy)

        int count1 = (maxW / weight1);
        int curV = count1 * value1;
        int curW = count1 * weight1;

        int remainedWeight = maxW - curW;
        while ((remainedWeight / weight2) > 0) {
            curV += value2;
            remainedWeight -= weight2;
        }

        int res = curV;
        int weightCapacity = 0;
        while (count1 != 0) {
            count1--;
            curV -= value1;
            weightCapacity += weight1;
            while ((weightCapacity / weight2) > 0) {
                curV += value2;
                weightCapacity -= weight2;
            }
            res = Math.max(res, curV);
        }

        return res;
    }

    public static void main(String[] args) {
        var s = new KnapsackLight();
        System.out.println(s.solution(5,3,7,4,6));
    }
}
