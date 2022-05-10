package Algorithm_III.Day8.problem582;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<Integer, Integer> parentMap = new HashMap<>();
    List<Integer> resList = new ArrayList<>();

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        for (int i = 0; i < pid.size(); i++) {
            parentMap.put(pid.get(i), ppid.get(i));
        }

        dfs(kill);
        return resList;
    }

    private void dfs(Integer kill) {
        for (Integer key : parentMap.keySet()) {
            if (kill.equals(parentMap.get(key))) {
                resList.add(key);
                dfs(key);
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.killProcess(Arrays.asList(1, 3, 10, 5), Arrays.asList(3, 0, 5, 3), 5));
//        System.out.println(solution.killProcess(Arrays.asList(1, 2, 3), Arrays.asList(0, 1, 2), 1));
        System.out.println(solution.killProcess(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(0, 1, 1, 1, 1), 1));
    }
}
