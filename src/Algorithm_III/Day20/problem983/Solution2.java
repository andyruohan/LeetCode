package Algorithm_III.Day20.problem983;

import java.util.HashSet;

public class Solution2 {
    int[] ticketCost;
    Integer[] minCostFromNow;
    HashSet<Integer> travelDays;
    int length;

    public int mincostTickets(int[] days, int[] costs) {
        this.ticketCost = costs;
        this.length = days.length;
        minCostFromNow = new Integer[length];
        return getMinCostFrom(0);
    }

    public int getMinCostFrom(int i) {
        if (i > length) {
            return 0;
        }

        if (minCostFromNow[i] != null) {
            return minCostFromNow[i];
        }

        minCostFromNow[i] = Integer.MAX_VALUE;
        int j = i;
        for (int k = 0; k < 3; ++k) {
//            while () {
//                ++j;
//            }
            minCostFromNow[i] = Math.min(minCostFromNow[i], getMinCostFrom(i + j) + ticketCost[k]);
        }
        return minCostFromNow[i];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 17}));
    }
}
