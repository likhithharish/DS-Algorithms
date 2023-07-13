package Deque_DSA;

import java.util.Deque;
import java.util.LinkedList;

public class CircularTour {

    /*
     * There are n gas stations along a circular route, where the amount of gas at
     * the ith station is gas[i].
     * 
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to
     * travel from the ith station to its next (i + 1)th station. You begin the
     * journey with an empty tank at one of the gas stations.
     * 
     * Given two integer arrays gas and cost, return the starting gas station's
     * index if you can travel around the circuit once in the clockwise direction,
     * otherwise return -1. If there exists a solution, it is guaranteed to be
     * unique
     */

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // Naive
        for (int start = 0; start < gas.length; start++) {
            int curr_gas = 0;
            int end = start;
            while (true) {
                curr_gas += (gas[end] - cost[end]);
                if (curr_gas < 0) {
                    break;
                }
                end = (end + 1) % gas.length;
                if (start == end) {
                    return (start + 1);
                }
            }
        }
        return -1;
    }

    public static int efficitentSol(int[] gas, int[] cost) {
        Deque<Integer> dq = new LinkedList<>();
        int n = gas.length;
        int curr_gas = 0;
        for (int i = 0; i < 2 * n; i++) {
            int k = (i % n);
            curr_gas += gas[k] - cost[k];
            if (curr_gas >= 0) {
                dq.addLast(k);
            } else {
                while (!dq.isEmpty() && (curr_gas - (gas[dq.peekFirst()] - cost[dq.peekFirst()])) < 0) {
                    int index = dq.removeFirst();
                    curr_gas -= (gas[index] - cost[index]);
                }
                if (dq.isEmpty() && curr_gas < 0) {
                    curr_gas = 0;
                }
            }

            if (dq.size() == n) {
                return dq.peekFirst() + 1;
            }
        }
        return -1;
    }

    public static int moreEfficient(int[] gas, int[] cost) {
        int start = 0, curr_gas = 0;
        int prev_gas = 0;
        for (int i = 0; i < gas.length; i++) {
            curr_gas += gas[i] - cost[i];
            if (curr_gas < 0) {
                start = i + 1;
                prev_gas += curr_gas;
                curr_gas = 0;
            }
        }

        return (prev_gas + curr_gas >= 0) ? (start) : -1;
    }

    public static void main(String[] args) {
        int[] gas = { 4, 8, 7, 4 };
        int[] cost = { 6, 5, 3, 5 };
        System.out.println(efficitentSol(gas, cost));
    }
}
