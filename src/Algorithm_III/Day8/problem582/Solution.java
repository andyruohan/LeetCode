package Algorithm_III.Day8.problem582;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<Integer, List<Integer>> parentMap = new HashMap<>();
    List<Integer> resList = new ArrayList<>();

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        for (int i = 0; i < ppid.size(); i++) {
            List<Integer> currentValues = parentMap.get(ppid.get(i));
            if (currentValues == null) {
                List<Integer> tempValue = new ArrayList<>();
                tempValue.add(pid.get(i));
                parentMap.put(ppid.get(i), tempValue);
            } else {
                currentValues.add(pid.get(i));
            }
        }

        resList.add(kill);
        dfs(kill);
        return resList;
    }

    private void dfs(Integer kill) {
        List<Integer> currentValues = parentMap.get(kill);
        if (currentValues != null) {
            for (Integer value : currentValues) {
                resList.add(value);
                dfs(value);
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.killProcess(Arrays.asList(1, 3, 10, 5), Arrays.asList(3, 0, 5, 3), 5));
//        System.out.println(solution.killProcess(Arrays.asList(1, 2, 3), Arrays.asList(0, 1, 2), 1));
//        System.out.println(solution.killProcess(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(0, 1, 1, 1, 1), 1));
    }
}
