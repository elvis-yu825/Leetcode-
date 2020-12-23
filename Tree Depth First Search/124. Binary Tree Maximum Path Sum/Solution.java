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
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        sumUp(root);
        return result;
    }
    private static int sumUp(TreeNode currentNode) {
        if (currentNode == null) return 0;
        int leftSum = sumUp(currentNode.left);
        int rightSum = sumUp(currentNode.right);
        //ignore any path with negative sum
        leftSum = Math.max(leftSum,0);
        rightSum = Math.max(rightSum,0);
        int currentSum = leftSum + rightSum + currentNode.val;
        result = Math.max(result,currentSum);
        //maximum sum of any path from the current node will be equal to the maximum of the sums from left or right plus the value of the current node
        return Math.max(leftSum,rightSum) + currentNode.val;
    }
}
