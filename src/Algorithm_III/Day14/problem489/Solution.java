package Algorithm_III.Day14.problem489;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0, new HashSet<>());
    }

    private void dfs(Robot robot, int x, int y, int d, Set<String> visited) {
        visited.add(x + "," + y);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int nd = (i + d) % 4;
            int x0 = x + dirs[nd][0];
            int y0 = y + dirs[nd][1];
            if (!visited.contains(x0 + "," + y0) && robot.move()) {
                dfs(robot, x0, y0, nd, visited);
            }
            robot.turnRight();
        }

        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
}
