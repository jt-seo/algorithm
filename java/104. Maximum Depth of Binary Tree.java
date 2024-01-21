// Given the root of a binary tree, return its maximum depth.

// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

import java.util.LinkedList;
import java.util.Queue;
import java.util.AbstractMap.SimpleEntry;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


 class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

// Search depth with BFS
class SolutionBFS {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<SimpleEntry<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new SimpleEntry<>(root, 1));
        int maxDepth = 0;
        
        while (!queue.isEmpty()) {
            SimpleEntry<TreeNode, Integer> current = queue.poll();
            TreeNode node = current.getKey();
            int depth = current.getValue();
            
            if (node != null) {
                maxDepth = Math.max(maxDepth, depth);
                queue.add(new SimpleEntry<>(node.left, depth + 1));
                queue.add(new SimpleEntry<>(node.right, depth + 1));
            }
        }
        
        return maxDepth;
    }
}