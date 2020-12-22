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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) return arr.length == 0;
        return findPath(root, arr, 0);
    }
    
    private static boolean findPath(TreeNode currentNode, int[] arr, int index) {
        if (currentNode == null) return false;
        if ((index >= arr.length) || currentNode.val != arr[index]) {
            return false;
        }
        //if current node is leaf and it is the end of the sequence, we found a path
        if (currentNode.left == null && currentNode.right == null && index == arr.length-1) {
            return true;
        }
        //recursivelly call to traverse the left and right sub-tree
        // return true if any of the two recursive call return true
        return findPath(currentNode.left, arr, index+1) || findPath(currentNode.right, arr, index+1);
    }
    
    
}
