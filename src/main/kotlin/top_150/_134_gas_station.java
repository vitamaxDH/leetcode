package top_150;

import java.util.Arrays;

public class _134_gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1 && gas[0] - cost[0] >= 0) {
            return 0;
        }

        for (int s = 0; s < gas.length; s++) {
            var route = 0;
            var tank = 0;
            var started = false;
            for (int i = s; route < gas.length; i = i + 1 == gas.length ? 0 : i + 1) {
                route++;
                tank += (gas[i] - cost[i]);
                if (started ? tank < 0 : tank <= 0) {
                    break;
                }
                if (i == s) {
                    started = true;
                }
            }
            if (route == gas.length) {
                return s;
            }
        }

        return -1;
    }

    public int canCompleteCircuit_better_solution(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) return -1;

        var total = 0;
        var res = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var ans = new _134_gas_station();
        System.out.println(ans.canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
        System.out.println(ans.canCompleteCircuit(new int[] {2,3,4}, new int[] {3,4,3}));
        System.out.println(ans.canCompleteCircuit(new int[] {2}, new int[] {2}));
    }
}

