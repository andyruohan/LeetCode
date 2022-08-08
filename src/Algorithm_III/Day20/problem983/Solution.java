package Algorithm_III.Day20.problem983;

import java.util.HashSet;

public class Solution {
    int[] ticketCost;
    Integer[] minCostFromNow;
    HashSet<Integer> travelDays;

    public int mincostTickets(int[] days, int[] costs) {
        this.ticketCost = costs;
        minCostFromNow = new Integer[366];
        travelDays = new HashSet<>();
        for (int day: days) {
            travelDays.add(day);
        }
        return getMinCostFrom(1);
    }

    public int getMinCostFrom(int i) {
        if (i > 365) {
            return 0;
        }

        if (minCostFromNow[i] != null) {
            return minCostFromNow[i];
        }

        if (travelDays.contains(i)) {
            minCostFromNow[i] = Math.min(Math.min(getMinCostFrom(i + 1) + ticketCost[0], getMinCostFrom(i + 7) + ticketCost[1]), getMinCostFrom(i + 30) + ticketCost[2]);
        } else {
            minCostFromNow[i] = getMinCostFrom(i + 1);
        }
        return minCostFromNow[i];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 17}));
    }
}
