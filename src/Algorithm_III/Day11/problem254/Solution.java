package Algorithm_III.Day11.problem254;

import java.util.*;

public class Solution {
    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {

        return null;
    }

    private void dfs() {

    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(1);
        System.out.println(set1.equals(set2));

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(1);
        System.out.println(list1.equals(list2));
        
        Collections.sort(list1);
        Collections.sort(list2);
        System.out.println(list1.equals(list2));
    }
}
