// 98. Validate Binary Search Tree

// BST 에서는 node 의 왼쪽이 node 의 값보다 작아야 하고, node 의 오른쪽은 node 의 값보다 커야 한다.
// node 의 값의 범위가 가져야 할 범위를 체크해서 valid 한지 확인.

// Medium
// Topics
// Companies
// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:

// The left 
// subtree
//  of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        
        if (node.val <= min || node.val >= max) {
            return false;
        }
        
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
