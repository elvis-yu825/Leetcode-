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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        pathSumRecursive(root, sum, currentPath, allPaths);
        return allPaths;
    }
    
    private static void pathSumRecursive(TreeNode currentNode, int sum, List<Integer> currentPath, 
                                        List<List<Integer>> allPaths) {
        if (currentNode == null)
            return;
        //add the current node to the path
        currentPath.add(currentNode.val);
        //if the current node is a leaf node and its value is equal to the sum, save the current path
        if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            //treverse the left subtree
            pathSumRecursive(currentNode.left, sum-currentNode.val, currentPath, allPaths);
            //traverse the right subtree
            pathSumRecursive(currentNode.right, sum-currentNode.val, currentPath, allPaths);
        }
        //remove the current node from the path to backtrack
        currentPath.remove(currentPath.size()-1);
    }
    
}
