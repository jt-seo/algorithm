// 114. Flatten Binary Tree to Linked List
// Medium
// Topics
// Companies
// Hint
// Given the root of a binary tree, flatten the tree into a "linked list":

// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

// Example 1:


// Input: root = [1,2,5,3,4,null,6]
// Output: [1,null,2,null,3,null,4,null,5,null,6]
// Example 2:

// Input: root = []
// Output: []
// Example 3:

// Input: root = [0]
// Output: [0]
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100
 

// Follow up: Can you flatten the tree in-place (with O(1) extra space)?

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
    
    private TreeNode flattenTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        
        // 리프 노드인 경우 자기 자신을 반환
        if (node.left == null && node.right == null) {
            return node;
        }
        
        // 왼쪽 서브트리 평탄화
        TreeNode leftTail = flattenTree(node.left);
        
        // 오른쪽 서브트리 평탄화
        TreeNode rightTail = flattenTree(node.right);
        
        // 왼쪽 서브트리를 오른쪽으로 이동
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        // 오른쪽 꼬리가 존재하면 반환, 그렇지 않으면 왼쪽 꼬리 반환
        return rightTail == null ? leftTail : rightTail;
    }
}
