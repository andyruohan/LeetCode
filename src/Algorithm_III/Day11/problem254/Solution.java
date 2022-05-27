package Algorithm_III.Day11.problem254;

import java.util.*;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        return dfs(2, n);
    }

    private List<List<Integer>> dfs(int start, int n) {
        if (n == 1) {
            return new ArrayList<>();
        }

        int end = (int)Math.sqrt(n);
        List<List<Integer>> factorList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (n % i == 0) {
                List<Integer> directFactors = new ArrayList<>();
                directFactors.add(i);
                directFactors.add(n / i);
                factorList.add(directFactors);
                List<List<Integer>> remainingFactorList = dfs(i, n / i);
                for (List<Integer> remainingFactors: remainingFactorList){
                    remainingFactors.add(i);
                    factorList.add(remainingFactors);
                }
            }
        }
        return factorList;
    }

    public static void main(String[] args) {
//        Set<Integer> set1 = new HashSet<>();
//        set1.add(1);
//        set1.add(2);
//        Set<Integer> set2 = new HashSet<>();
//        set2.add(2);
//        set2.add(1);
//        System.out.println(set1.equals(set2));
//
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(2);
//        list2.add(1);
//        System.out.println(list1.equals(list2));
//
//        Collections.sort(list1);
//        Collections.sort(list2);
//        System.out.println(list1.equals(list2));

        Solution solution = new Solution();
        System.out.println(solution.getFactors(12));
    }
}
