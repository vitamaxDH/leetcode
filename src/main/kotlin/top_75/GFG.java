package top_75;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class GFG {

    private static class TrainSchedule {
        int arrivalTime, deptTime;

        TrainSchedule(int arrivalTime, int deptTime) {
            this.arrivalTime = arrivalTime;
            this.deptTime = deptTime;
        }

        public String toString() {
            return "(" + this.arrivalTime + ","
                    + this.deptTime + ")";
        }
    }

    // Function to find the minimum number
    // of platforms required
    public static int countPlatforms(int[] arr, int[] dep) {
        TrainSchedule[] trains
                = new TrainSchedule[arr.length];
        // Store the arrival and departure time
        for (int i = 0; i < arr.length; i++) {
            trains[i] = new TrainSchedule(arr[i], dep[i]);
        }
        // Sort trains based on arrival time
        Arrays.sort(trains, Comparator.comparingInt(o -> o.arrivalTime));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(trains[0].deptTime);
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            TrainSchedule curr = trains[i];
            // Check if arrival time of current train
            // is less than or equals to departure time
            // of previous train
            if (curr.arrivalTime <= pq.peek()) {
                count++;
            } else {
                pq.poll();
            }
            pq.add(curr.deptTime);
        }
        // return the count of number of platforms required
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        int res = countPlatforms(arr, dep);
        System.out.println(res);
    }
}
