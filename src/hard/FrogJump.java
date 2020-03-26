package hard;

import java.util.Arrays;

/**
 * @author 潘磊明
 * @date 2020/2/11
 */
public class FrogJump {
    /**
     * 记忆化搜索
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        int[][] mem = new int[stones.length][stones.length];
        for(int i = 0; i < mem.length; i++) Arrays.fill(mem[i], -1);
        return canCross(stones, 0, 0, mem) == 1;
    }

    private int canCross(int[] stones, int ind, int step, int[][] mem) {
        if (mem[ind][step] >= 0) {
            return mem[ind][step];
        }
        for (int i = ind + 1; i < stones.length; i++) {
            int distance = stones[i] - stones[ind];
            if (distance >= step - 1 && distance <= step + 1) {
                if (canCross(stones, i, distance, mem) == 1) {
                    mem[ind][distance] = 1;
                    return 1;
                }
            }
        }
        mem[ind][step] = ind == stones.length - 1 ? 1 : 0;
        return mem[ind][step];
    }
}
