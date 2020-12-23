/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static int result;
    public int diameterOfBinaryTree(TreeNode root) {
        result = 1;
        calculateHeight(root);
        return result-1;
    }
    
    private static int calculateHeight(TreeNode currentNode) {
        if (currentNode == null) return 0;
        int leftTreeHeight = calculateHeight(currentNode.left);
        int rightTreeHeight = calculateHeight(currentNode.right);
        //diameter at the current node will be equal to the height of left subtree + the height
        //of right sub-tree + "1" for the current node
        int diameter = leftTreeHeight + rightTreeHeight+1;
        //update the global result
        result = Math.max(diameter,result);
        //height of the current node will be equal to the maximum of the heights of left or right subtree plus
        //"1" for the current node
        return Math.max(leftTreeHeight,rightTreeHeight)+1;
    }
}
