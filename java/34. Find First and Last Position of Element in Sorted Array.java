// 34. Find First and Last Position of Element in Sorted Array

// Binary Search (중복된 값의 첫과 끝 인덱스)

// Medium

// 19842

// 481

// Add to List

// Share
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);
        return result;
    }
    
    private int findStartingIndex(int[] nums, int target) {
        int index = -1;
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
            if (nums[mid] == target) index = mid;
        }
        
        return index;
    }
    
    private int findEndingIndex(int[] nums, int target) {
        int index = -1;
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
            if (nums[mid] == target) index = mid;
        }
        
        return index;
    }
}
