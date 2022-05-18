package Algorithm_III.Day10.problem1192;

import java.util.*;

public class Solution {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    List<List<Integer>> resList = new ArrayList<>();
    int[] ids;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        buildMap(connections);
        ids = new int[n];
        Arrays.fill(ids, -1);
        dfs(0, 0, 0);
        return resList;
    }

    private Integer dfs(int node, int parent, int id) {
        ids[node] = id;
        for (Integer neighbor: map.get(node)) {
            if (neighbor == parent) {
                continue;
            } else if (ids[neighbor] == -1) {
                ids[node] = Math.min(ids[node], dfs(neighbor, node, id + 1));
            } else if (ids[neighbor] != -1) {
                ids[node] = Math.min(ids[node], ids[neighbor]);
            }
        }

        if (ids[node] == id && node != 0) {
            resList.add(Arrays.asList(parent, node));
        }

        return ids[node];
    }

    private void buildMap(List<List<Integer>> connections) {
        for (List<Integer> connection: connections){
            int a = connection.get(0);
            int b = connection.get(1);

            Set<Integer> setFromA = map.getOrDefault(a, new HashSet<>());
            Set<Integer> setFromB = map.getOrDefault(b, new HashSet<>());

            setFromA.add(b);
            setFromB.add(a);

            map.put(a, setFromA);
            map.put(b, setFromB);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        System.out.println(solution.criticalConnections(4, connections));
    }
}
