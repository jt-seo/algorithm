// Two pointers

// You are given an integer array height of length n. 
// There are n vertical lines drawn such that the two endpoints of the ith line 
// are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, 
// such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxStorage = 0;

        while (left < right) {
            int storage = Math.min(height[left], height[right]) * (right - left);
            maxStorage = Math.max(maxStorage, storage);

            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return maxStorage;
    }
}