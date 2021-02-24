package problems_by_year.year_2021.month_01.problems_0117.Merge_Intervals;

import java.util.Arrays;

/**
 * ClassName SolutionA1
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2021/1/25 1:50 下午
 */
public class SolutionA1 {

    public static void main(String[] args) {
        int[][] nums = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        SolutionA1 solution = new SolutionA1();
        solution.merge(nums);
    }

    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

}
