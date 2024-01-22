// Sort 한 후 앞 뒤에 l, r 을 이동시키면서 조건에 만족하는 조합을 구한다.
// Improve from O(n^3) to O(nlogn + n^2)

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.
import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    // got it
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }

                if (nums[left] + nums[right] + nums[i] > 0) {
                    int prevNum = nums[right];
                    do {
                        right--;    // skip duplicated numbers
                    } while (right > left && nums[right] == prevNum);
                } else {
                    int prevNum = nums[left];
                    do {
                        left++; // skip duplicated numbers
                    } while (left < right && nums[left] == prevNum);
                }
            }
        }
        return list;
    }
}