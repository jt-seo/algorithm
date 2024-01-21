// 105. Construct Binary Tree from Preorder and Inorder Traversal
// pre-order: root, pre-order(left), pre-order(right) (dfs)
// in-order: in-order(left), root, in-order(right)
// post-order: post-order(left), post-order(right), root
// pre-order 의 앞은 항상 root 이다.
// in-order 는 항상 root 기준으로 왼쪽은 좌측 tree, 오른쪽은 우측 tree 로 만들어 진다.
// in-order node 번호와 index 를 HashMap 에 넣어두고
// pre-order 의 root 부터 시작해서 root 의 위치를 inorder 에서 찾은 후
// 왼쪽 tree 를 재귀적으로 구성해 root->left 에 넣고, 오른쪽도 동일하게 찾는다.
// 좌우 tree 의 index 범위가 좁아지면서 tree 가 완성된다.

// Medium
// Topics
// Companies
// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

// Example 1:


// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
// Example 2:

// Input: preorder = [-1], inorder = [-1]
// Output: [-1]

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = buildTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = buildTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }
}
