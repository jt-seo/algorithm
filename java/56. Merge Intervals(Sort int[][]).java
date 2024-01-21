// 56. Merge Intervals

// Sort int[][] 
// Arrays.sort(result, (int a, int b) -> Integer.compare(a, b))

// Solved
// Medium
// Topics
// Companies
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 // Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

// Constraints:

// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
import java.util.*;

class Solution {
    private int[][] convToArray(ArrayList<int[]> list) {
        int[][] ret = new int[list.size()][];
        for (int i=0; i<list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    public int[][] merge(int[][] intervals) {
        // sort intervals.
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));

        int start = -1;
        int end = -1;
        ArrayList<int[]> result = new ArrayList<>();
        for (int i=0; i<intervals.length; i++) {
            start = intervals[i][0];
            end = intervals[i][1];
            while (i + 1 < intervals.length && intervals[i+1][0] <= end) {
                i++;
                end = Math.max(end, intervals[i][1]);
            }

            result.add(new int[]{start, end});
        }
        return convToArray(result);
    }
}