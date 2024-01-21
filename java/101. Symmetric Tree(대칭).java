// 101. Symmetric Tree

// 트리가 대칭인지 확인하려면
// 자식 노드들이 mirror 인지 확인하면 된다.
// 두 노드가 mirror 인 건 두 노드의 값이 같고,
// 한 노드의 왼쪽이 다른 노드의 오른쪽과 mirror 이고, 오른쪽이 왼쪽과 mirror 여야 한다.

// Easy
// Topics
// Companies
// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

// Example 1:


// Input: root = [1,2,2,3,4,4,3]
// Output: true
// Example 2:


// Input: root = [1,2,2,null,3,null,3]
// Output: false

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.val == node2.val)
            && isMirror(node1.left, node2.right)
            && isMirror(node1.right, node2.left);
    }
}
