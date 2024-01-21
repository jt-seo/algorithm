// 530. Minimum Absolute Difference in BST

// BST 에서 in-order 로 순회하면 min ~ max 까지 순차적으로 접근 가능.

// Easy
// Topics
// Companies
// Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 

// Example 1:


// Input: root = [4,2,6,1,3]
// Output: 1
// Example 2:


// Input: root = [1,0,48,null,null,12,49]
// Output: 1

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    Integer prevNodeVal = null;
    int minDiff = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }
    
    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inorderTraversal(node.left);
        
        if (prevNodeVal != null) {
            minDiff = Math.min(minDiff, node.val - prevNodeVal);
        }
        prevNodeVal = node.val;
        
        inorderTraversal(node.right);
    }
}
