// 3. Longest Substring Without Repeating Characters
// Solved
// Medium
// Topics
// Companies
// Given a string s, find the length of the longest 
// substring
//  without repeating characters.
class Solution {
    private int getDuplicatedIndex(String s, int startIndex, int endIndex) {
        char c = s.charAt(endIndex);
        for (int i=startIndex; i<endIndex; i++) {
            if (s.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int strLen = s.length();
        int maxLen = 1;
        if (strLen == 0) {
            return 0;
        }

        for (int right = 1; right < strLen; right++) {
            int dupIndex = getDuplicatedIndex(s, left, right);
            if (dupIndex < 0) {
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                left = dupIndex + 1;
            }
        }
        return maxLen;
    }
}