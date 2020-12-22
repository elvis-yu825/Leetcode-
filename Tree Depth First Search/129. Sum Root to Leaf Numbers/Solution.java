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
    public int sumNumbers(TreeNode root) {
        return findSum(root,0);
    }
    private static int findSum(TreeNode currentNode, int pathSum) {
        if (currentNode == null) return 0;
        // calculate the path number of the current node
        pathSum = 10 * pathSum + currentNode.val;
        //if the current node is a leaf, return the current path sum;
        if (currentNode.left == null && currentNode.right == null) {
            return pathSum;
        }
        return findSum(currentNode.left, pathSum) + findSum(currentNode.right, pathSum);
    }
}
