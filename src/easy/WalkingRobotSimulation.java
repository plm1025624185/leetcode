package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/11/4
 */
public class WalkingRobotSimulation {
//    public int robotSim(int[] commands, int[][] obstacles) {
//        int direction = 0; //机器人前行的方向 0-right, 1-down, 2-left, 3-up
//        Set<String> obstaclesSet = obstracles2Set(obstacles);
//        int i = 0, j = 0;
//        int distance = 0;
//        int max = 0;
//        for (int x = 0; x < commands.length; x++) {
//            if (isDirection(commands[x])) direction = getDirection(commands[x], direction);
//            else {
//                if (direction == 0) j = moveRight(obstaclesSet, i, j, commands[x]);
//                else if (direction == 1) i = moveDown(obstaclesSet, i, j, commands[x]);
//                else if (direction == 2) j = moveLeft(obstaclesSet, i, j, commands[x]);
//                else i = moveUp(obstaclesSet, i, j, commands[x]);
//                max = Math.max(max, i * i + j * j);
//            }
//        }
//        return max;
//    }
//
//    private Set<String> obstracles2Set(int[][] obstacles){
//        Set<String> set = new HashSet<>();
//        for (int i = 0; i < obstacles.length; i++) {
//            set.add(obstacles[i][0] + "@" + obstacles[i][1]);
//        }
//        return set;
//    }
//
//    private boolean isDirection(int value){
//        return value < 0;
//    }
//
//    /**
//     * 获取当前机器人行走的方向
//     * @param direct
//     * @return
//     */
//    private int getDirection(int direct, int direction){
//        if (direct == -1) direction++;
//        else if (direct == -2) direction--;
//        if (direction > 3) return direction - 4;
//        else if (direction < 0) return direction + 4;
//        else return direction;
//    }
//
//    private int moveRight(Set<String> set, int i, int j, int distance) {
//        for (int x = 1; x < distance + 1; x++) {
//            if (set.contains(i + "@" + (j + x))) {
//                return x + j - 1;
//            }
//        }
//        return j + distance;
//    }
//
//    private int moveLeft(Set<String> set, int i, int j, int distance) {
//        for (int x = 1; x < distance + 1; x++) {
//            if (set.contains(i + "@" + (j - x))) {
//                return j - x + 1;
//            }
//        }
//        return j - distance;
//    }
//
//    private int moveUp(Set<String> set, int i, int j, int distance) {
//        for (int x = 1; x < distance + 1; x++) {
//            if (set.contains((i - x) + "@" + j)) {
//                return i - x + 1;
//            }
//        }
//        return i - distance;
//    }
//
//    private int moveDown(Set<String> set, int i, int j, int distance) {
//        for (int x = 1; x < distance + 1; x++) {
//            if (set.contains((i + x) + "@" + j)) {
//                return i + x - 1;
//            }
//        }
//        return i + distance;
//    }

//    public static void main(String[] args) {
//        WalkingRobotSimulation w = new WalkingRobotSimulation();
//        int[] commands = new int[]{4, -1, 4, -2, 4};
//        int[][] obstacles = new int[][]{
//                new int[]{2,4}
//        };
//        w.robotSim(commands, obstacles);
//    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] steps = new int[][]{
                new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0}
        };
        int step = 0;
        Set<String> set = new HashSet<>();
        obstacles2Set(set, obstacles);
        int max = 0;
        int x = 0, y = 0;
        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            if (command == -1 || command == -2) step = changeStep(step, command);
            else {
                int tx = x, ty = y;
                x = tx + command * steps[step][0];
                y = ty + command * steps[step][1];
                if (step == 0) {
                    for (int j = ty + 1; j <= y; j++) {
                        if (set.contains(x + "@" + j)) {
                            y = j - 1;
                            break;
                        }
                    }
                } else if (step == 1) {
                    for (int j = tx + 1; j <= x; j++) {
                        if (set.contains(j + "@" + y)) {
                            x = j - 1;
                            break;
                        }
                    }
                } else if (step == 2) {
                    for (int j = ty - 1; j >= y; j--) {
                        if (set.contains(x + "@" + j)) {
                            y = j + 1;
                            break;
                        }
                    }
                } else {
                    for (int j = tx - 1; j >= x; j--) {
                        if (set.contains(j + "@" + y)) {
                            x = j + 1;
                            break;
                        }
                    }
                }
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }

    private int changeStep(int step, int command) {
        if (command == -1) return step + 1 > 3 ? step - 3 : step + 1;
        else return step - 1 < 0 ? step + 3 : step - 1;
    }

    private void obstacles2Set(Set<String> set, int[][] obstacles) {
        for (int i = 0; i < obstacles.length; i++) {
            int row = obstacles[i][0];
            int col = obstacles[i][1];
           set.add(row + "@" + col);
        }
    }

    public static void main(String[] args) {
        WalkingRobotSimulation w = new WalkingRobotSimulation();
        w.robotSim(new int[]{-2,-1,-2,3,7}, new int[][]{
                new int[]{1,-3}, new int[]{2,-3}, new int[]{4,0}, new int[]{-2,5},
                new int[]{-5,2}, new int[]{0,0}, new int[]{4,-4}, new int[]{-2,-5},
                new int[]{-1,-2}, new int[]{0,2}
        });
    }
}