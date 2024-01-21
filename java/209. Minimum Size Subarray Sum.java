// Sliding Window

// 윈도우 구성 후 왼쪽 제거 -> 오른쪽 추가 하면서 minimum length 를 구한다.

// 209. Minimum Size Subarray Sum
// Solved
// Medium
// Topics
// Companies
// Given an array of positive integers nums and a positive integer target, return the minimal length of a 
// subarray
//  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right=0; right<length; right++) {
            sum += nums[right];

            while (sum >= target) {
                // left ~ right
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}